package com.example.ECom_proj.Service;

import com.example.ECom_proj.Repository.ProductRepo;
import com.example.ECom_proj.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service

public class ProductService {

    @Autowired
     private ProductRepo Repo;
    public List<Product> getAllproducts() {

        return Repo.findAll();
    }

    public Product getproducts(int id) {

        return Repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImagetype(imageFile.getContentType());
        product.setImagedata(imageFile.getBytes());
        return Repo.save(product);
    }
}
