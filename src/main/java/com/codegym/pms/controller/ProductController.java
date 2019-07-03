package com.codegym.pms.controller;

import com.codegym.pms.model.Product;
import com.codegym.pms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productRepository.addProduct(product);
        redirectAttributes.addFlashAttribute("method", "created");
        redirectAttributes.addFlashAttribute("productName", product.getName());
        return "redirect:/product";

    }

    @GetMapping("/detail")
    public ModelAndView showEditForm(@RequestParam int productId){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product",productRepository.findProductById(productId));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productRepository.updateProduct(product.getId(),product);
        redirectAttributes.addFlashAttribute("method", "edited");
        redirectAttributes.addFlashAttribute("productName", product.getName());
        return "redirect:/product";
    }
}
