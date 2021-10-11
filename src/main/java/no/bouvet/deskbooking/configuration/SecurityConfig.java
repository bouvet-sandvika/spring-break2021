package no.bouvet.deskbooking.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
        super(false);
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(List.of(customAuthenticationProvider));
    }

}
