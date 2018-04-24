package ru.ivmiit.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.store.model.StoreUser;
import ru.ivmiit.store.repository.StoreUserRepository;
import ru.ivmiit.store.security.StoreUserDetailsImpl;

@Service
public class StoreUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StoreUserRepository storeUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        StoreUser storeUser = storeUserRepository.findOneByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("User not found by login <" + login + ">"));
        return new StoreUserDetailsImpl(storeUser);
    }
}
