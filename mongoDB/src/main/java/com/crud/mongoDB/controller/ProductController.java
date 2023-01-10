package com.crud.mongoDB.controller;


import com.crud.mongoDB.model.ProductDetails;
import com.crud.mongoDB.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/allProducts")
    public List<ProductDetails> returnAll()
    {
        return productService.returnAll();
    }
    @RequestMapping("/allProducts/{id}")
    public Optional<ProductDetails> getInventory(@PathVariable Long id)
    {
        return productService.getProduct(id);
    }
    @RequestMapping(method= RequestMethod.POST,value="/allProducts")
    public void addInventory(@RequestBody ProductDetails Inventory)
    {
        productService.addProduct(Inventory);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/allProducts/{id}")
    public void deleteInventory(@PathVariable Long id)
    {
        productService.deleteProduct(id);
    }
    @RequestMapping(method=RequestMethod.PUT,value="/allProducts/{id}")
    public void updateInventory(@RequestBody ProductDetails Inventory,@PathVariable Long id)
    {
        productService.updateProduct(id, Inventory);
    }
}
