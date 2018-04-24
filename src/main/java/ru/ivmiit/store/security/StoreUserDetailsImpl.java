package ru.ivmiit.store.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ivmiit.store.model.StoreUser;

import java.util.Collection;
import java.util.Collections;

public class StoreUserDetailsImpl implements UserDetails {

    private StoreUser storeUser;

    public StoreUserDetailsImpl(StoreUser storeUser) {
        this.storeUser = storeUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(storeUser.getRole().getName()));
    }

    @Override
    public String getPassword() {
        return storeUser.getPassword();
    }

    @Override
    public String getUsername() {
        return storeUser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
        //return this.user.getState().equals(State.CONFIRMED);
    }

    public StoreUser getStoreUser() {
        return storeUser;
    }
}
