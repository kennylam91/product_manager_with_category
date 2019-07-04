package com.codegym.pms.controller;

import com.codegym.pms.model.Product;
import com.codegym.pms.service.CategoryService;
import com.codegym.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ModelAndView getProductTable() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", productService.findAllProduct());
        return modelAndView;

    }


    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("method", "created");
        redirectAttributes.addFlashAttribute("productName", product.getName());
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/product";

    }

    @GetMapping("/detail")
    public ModelAndView showEditForm(@RequestParam int productId) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.findProductById(productId));
        modelAndView.addObject("categories",categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product.getId(), product);
        redirectAttributes.addFlashAttribute("method", "edited");
        redirectAttributes.addFlashAttribute("productName", product.getName());
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam String productName,String productId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("productName", productName);
        redirectAttributes.addFlashAttribute("productId", productId);
        redirectAttributes.addFlashAttribute("delete", true);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int productId, RedirectAttributes redirectAttributes){
        productService.deleteProductById(productId);
        return "redirect:/product";
    }

}
