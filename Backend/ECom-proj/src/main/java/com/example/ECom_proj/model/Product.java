package com.example.ECom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.registry.selector.StrategyRegistration;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private BigDecimal product_price;
    private int quantity;
    private String Category;
    private Date releasedate;
    private boolean available;
    private String Brand;
    @Lob
    private String ImageName;
    private String Imagetype;
    private byte[] Imagedata;


}
