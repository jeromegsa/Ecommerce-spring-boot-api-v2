package gsa.webland.ecommercex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gsa.webland.ecommercex.model.Product;
import gsa.webland.ecommercex.service.ProductService;

/**
 * ProductController
 */
@RestController()
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product ProductToUpdate = productService.updateProduct(id, product);
        return ResponseEntity.ok(ProductToUpdate);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}