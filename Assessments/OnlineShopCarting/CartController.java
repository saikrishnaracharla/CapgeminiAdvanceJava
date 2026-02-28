package com.cg.ShopCart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cg.ShopCart.service.*;
import com.cg.ShopCart.model.*;

@Controller
public class CartController {

    @Autowired
    private ProductServie productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }
    @PostMapping("/add")
    public String addToCart(@RequestParam int productId,
                            @RequestParam int quantity) {

        Product product = productService.getProductById(productId);
        cartService.addToCart(product, quantity);

        return "redirect:/cart";
    }
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCart().values());
        model.addAttribute("total", cartService.getTotalAmt());
        return "cart";
    }
}
