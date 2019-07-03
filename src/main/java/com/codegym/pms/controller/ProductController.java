package com.codegym.pms.controller;

import com.codegym.pms.model.Product;
import com.codegym.pms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.codegym.pms.repository.impl.ProductRepositoryImpl.products;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ModelAndView getProductTable() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", productRepository.findAll());
        return modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productRepository.addProduct(product);
//        redirectAttributes.addFlashAttribute("products",products);
        return "redirect:/product";

    }
}
