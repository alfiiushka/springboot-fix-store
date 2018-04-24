package ru.ivmiit.store.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ivmiit.store.form.StoreUserRegistrationForm;
import ru.ivmiit.store.model.StoreUser;
import ru.ivmiit.store.repository.StoreUserRepository;

import java.util.Optional;

@Component
public class StoreUserRegistrationFormValidator implements Validator {

    @Autowired
    private StoreUserRepository storeUserRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(StoreUserRegistrationForm.class.getName());
    }

    @Override
    public void validate(Object o, Errors errors) {

        StoreUserRegistrationForm form = (StoreUserRegistrationForm) o;
        Optional<StoreUser> existedUser = storeUserRepository.findOneByLogin(form.getLogin());
        if (existedUser.isPresent()) {
            errors.reject("bad.login", "Логин занят");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Пустой логин");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Пустой пароль");

    }
}
