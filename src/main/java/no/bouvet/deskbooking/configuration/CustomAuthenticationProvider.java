package no.bouvet.deskbooking.configuration;

import java.util.ArrayList;

import no.bouvet.deskbooking.models.entities.User;
import no.bouvet.deskbooking.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder, PasswordEncoder passwordEncoder1) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder1;
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

        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
