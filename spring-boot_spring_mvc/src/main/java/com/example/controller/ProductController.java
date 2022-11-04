package com.example.controller;

import com.example.model.Product;
import com.example.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/products")
  public String viewProducts(Model model) {

    List<Product> productList = productService.findAll();
    model.addAttribute("products", productList);

    return "products.html";
  }

  @RequestMapping(path = "/products", method = RequestMethod.POST)
  public String addProduct(@RequestParam String name, @RequestParam Double price, Model model) {

    Product product = new Product();
    product.setPrice(price);
    product.setName(name);

    productService.addProduct(product);

    List<Product> products = productService.findAll();

    model.addAttribute("products", products);

    return "products.html";
  }
}
