package ru.ivmiit.store.service;


import org.springframework.security.core.Authentication;
import ru.ivmiit.store.form.StoreUserRegistrationForm;
import ru.ivmiit.store.model.StoreUser;

public interface StoreUserService {

    void saveStoreUser(StoreUserRegistrationForm storeUserRegistrationForm);

    StoreUser getStoreUserByAuthentication(Authentication authentication);
}
