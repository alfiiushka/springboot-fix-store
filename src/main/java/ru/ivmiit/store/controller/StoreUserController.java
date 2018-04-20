package ru.ivmiit.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreUserController {
    @GetMapping(path = "/storeUser")
    public String getStoreUser(ModelMap model){
        model.addAttribute("userName","Alfia");
        return "storeUser";
    }
}
