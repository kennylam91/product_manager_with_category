package com.codegym.pms.controller;

import com.codegym.pms.model.Product;
import com.codegym.pms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public ModelAndView getProductTable(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products",productRepository.findAll());
        return modelAndView;

    }
}
