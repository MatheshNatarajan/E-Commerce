package com.example.ECom_proj.Controller;

import com.example.ECom_proj.Service.ProductService;
import com.example.ECom_proj.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String product1() {
        return "Hello World!";
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getall() {
        return new ResponseEntity<>(service.getAllproducts(), HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product>getproductbyid(@PathVariable int id) {
        Product product = service.getproducts(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> addproduct(@RequestPart Product product,@RequestPart MultipartFile imageFile) {
        try{
            Product product1 = service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}