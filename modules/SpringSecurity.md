# 03 - Spring security

### Oppgave 1

Legg til Spring Security under dependencies og se at endepunktene vi har laget nå blir default sikret. Vi får et passord vi kan bruke i konsollen som ser slik ut: Using generated security password: 0cb4a8cd-98f2-4915-95a9-7b1f2a772672

Vi kan da autentisere oss med basic auth med brukernavn user og passordet spring genererte for oss. 

```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
```

### Oppgave 2 
Vi ønsker at bookings endepunktet ikke skal være sikret slik at alle kan gjøre spørringer for å se hva som er booket. 

For å gjøre det kan vi override WebSecurityConfigurerAdapter sin configure metode og ved bruk av antMatchers kan vi spesifisere hvilke endepunkter som ikke skal autentiseres. 

```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable() //disabler pga spring security liker ikke kall fra Postman uten videre
                .authorizeRequests()
                .antMatchers("/booking").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }
}
```

### Oppgave 3 InMemoryAuthentication
Det er mulig å enkelt lage egen bruker ved hjelp av inMemoryAuthentication 


```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("password"))
                .roles();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

### Oppgave 4 Legg til rollebasert autorization

Vi ønsker å begrense hvem som har tilgang til oppretting av pulter. Sikre metoden saveDesk i DeskController med og legg til rollen på brukeren vi laget i inMemoryAuthenticatioren (Ved bruk av .roles() blir roller automatisk prefikset med ROLE_) 
```java
@PostMapping
@RolesAllowed("ROLE_ADMIN")
public DeskDto saveDesk(@RequestBody DeskDto deskDto) {
    ...
}


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
```
Vi må også annotere configen med EnableGlobalMethodSecurity for å kunne bruke metode annoteringer for roller. Her slår vi på jsr250Enabled som er standard java spesifikasjon og tillater bruk av @RolesAllowed. (Det er også mulig å bruke Spring sin @Secured ved å sette securedEnabled = true)

### Oppgave 5 Autentisering med egen egen authenticationProvider
Eksempel på en custom authenticationProvider

```java
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("1000");
        }

        return new UsernamePasswordAuthenticationToken(username, password, List.of(new SimpleGrantedAuthority(user.getRole())));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
```

I security configen overrider man authenticationManageren slik og legger inn vår egen custom authenticationProvider.

```java
    @Override
    protected AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(customAuthenticationProvider));
    }
```

### Oppgave 6 
Det er mulig å sende inn en liste av authenticationProviders, prøv å lag en egen som autentiserer med feks token. 



### Ressurser
[Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture)

[Authorization Architecture](https://docs.spring.io/spring-security/site/docs/5.1.x/reference/html5/#authz-arch)
