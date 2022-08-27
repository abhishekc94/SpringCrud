package com.abhi.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_table")
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private int productId;
    private String name;
    private int quantity;
    private double price;

}
