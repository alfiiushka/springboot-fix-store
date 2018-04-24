package ru.ivmiit.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.store.enums.RoleEnum;
import ru.ivmiit.store.form.StoreUserRegistrationForm;
import ru.ivmiit.store.model.StoreUser;
import ru.ivmiit.store.service.StoreUserService;
import ru.ivmiit.store.validate.StoreUserRegistrationFormValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StoreUserController {

    @Autowired
    private StoreUserService storeUserService;

    @Autowired
    private StoreUserRegistrationFormValidator storeUserRegistrationFormValidator;


    @GetMapping("/signIn")
    public String signIn(@ModelAttribute("model") ModelMap model, Authentication authentication,
                         @RequestParam Optional<String> error) {
        if (authentication != null) {
            StoreUser storeUser = storeUserService.getStoreUserByAuthentication(authentication);
            if (storeUser.getRole().getCode().equals(RoleEnum.USER.getCode())) {
                return "redirect:/all-products";
            }
        }
        model.addAttribute("error", error);
        return "signIn";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/signIn";
    }

    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(storeUserRegistrationFormValidator);
    }

    @PostMapping(value = "/signUp")
    public String signUp(@Valid @ModelAttribute("userForm") StoreUserRegistrationForm storeUserRegistrationForm,
                         BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/signUp";
        }
        storeUserService.saveStoreUser(storeUserRegistrationForm);
        return "redirect:/signIn";
    }

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

}
