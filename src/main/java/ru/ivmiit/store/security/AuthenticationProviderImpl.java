package ru.ivmiit.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.ivmiit.store.model.StoreUser;
import ru.ivmiit.store.repository.StoreUserRepository;

import java.util.Collection;
import java.util.Optional;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    StoreUserRepository storeUserRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<StoreUser> userOptional = storeUserRepository.findOneByLogin(username);
        if (userOptional.isPresent()) {
            StoreUser storeUser = userOptional.get();
            if (!passwordEncoder.matches(password, storeUser.getPassword())) {
                throw new BadCredentialsException("Wrong password or login");
            }
        } else {
            throw new BadCredentialsException("Wrong password or login");
        }
        UserDetails details = userDetailsService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
        return new UsernamePasswordAuthenticationToken(details, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
