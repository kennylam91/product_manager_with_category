package com.codegym.pms.controller;

import com.codegym.pms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public ModelAndView getProductTable(){
        String products = productRepository.findAll().toString();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products",products);
        return modelAndView;

    }
}
