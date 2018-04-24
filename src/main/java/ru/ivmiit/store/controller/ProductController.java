package ru.ivmiit.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ivmiit.store.model.Product;
import ru.ivmiit.store.service.ProductService;
import ru.ivmiit.store.service.StoreUserService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private StoreUserService storeUserService;

    @GetMapping(path = "/all-products")
    public String getAllProducts(Authentication authentication, ModelMap model) {
        model.addAttribute("productList", productService.getAllProduct());
        model.addAttribute("storeUser", storeUserService.getStoreUserByAuthentication(authentication));
        return "getProduct";
    }

    @PostMapping(path = "/save-product")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "addProduct";
    }

    @GetMapping(path = "/save-product")
    public String getAddProductPage() {
        return "addProduct";
    }

}
