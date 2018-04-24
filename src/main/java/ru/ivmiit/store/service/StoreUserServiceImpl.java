package ru.ivmiit.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivmiit.store.enums.RoleEnum;
import ru.ivmiit.store.form.StoreUserRegistrationForm;
import ru.ivmiit.store.model.StoreUser;
import ru.ivmiit.store.repository.RoleRepository;
import ru.ivmiit.store.repository.StoreUserRepository;
import ru.ivmiit.store.security.StoreUserDetailsImpl;

@Service
public class StoreUserServiceImpl implements StoreUserService {

    @Autowired
    private StoreUserRepository storeUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveStoreUser(StoreUserRegistrationForm storeUserRegistrationForm) {
        StoreUser storeUser = new StoreUser();
        storeUser.setLogin(storeUserRegistrationForm.getLogin());
        storeUser.setPassword(new BCryptPasswordEncoder().encode(storeUserRegistrationForm.getPassword()));
        storeUser.setRole(roleRepository.findByCode(RoleEnum.USER.getCode()));
        storeUserRepository.save(storeUser);
    }

    @Override
    public StoreUser getStoreUserByAuthentication(Authentication authentication) {
        StoreUserDetailsImpl currentUserDetails = (StoreUserDetailsImpl) authentication.getPrincipal();
        StoreUser currentStoreUserModel = currentUserDetails.getStoreUser();
        Long currentStoreUserId = currentStoreUserModel.getId();
        return storeUserRepository.findOne(currentStoreUserId);
    }
}

