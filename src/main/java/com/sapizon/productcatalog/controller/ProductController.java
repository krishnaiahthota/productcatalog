package com.sapizon.productcatalog.controller;

import com.sapizon.productcatalog.model.ProductModel;
import com.sapizon.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> saveProducts() {
        productService.save(ProductModel.builder().id(1L).productName("test1").available(true).build());
        productService.save(ProductModel.builder().id(2L).productName("test2").available(true).build());
        productService.save(ProductModel.builder().id(3L).productName("test3").available(true).build());
        productService.save(ProductModel.builder().id(4L).productName("test4").available(true).build());
        return ResponseEntity.ok("saved");
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductModel product) {
        productService.updateProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody ProductModel product) {
        productService.deleteProduct(product.getId());
    }
    @GetMapping
    public ProductModel getProduct(@RequestParam Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/all")
    public List<ProductModel> getProducts() {
        return productService.getAllProducts();
    }
}
