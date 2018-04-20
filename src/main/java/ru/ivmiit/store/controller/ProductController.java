package ru.ivmiit.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ivmiit.store.model.Product;
import ru.ivmiit.store.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/all-products")
    public String getAllProducts(ModelMap model) {
        model.addAttribute("productList", productService.getAllProduct());
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
