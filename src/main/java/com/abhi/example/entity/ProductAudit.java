package com.abhi.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_audit_table")
public class ProductAudit {

    @Id
    @GeneratedValue
    private int auditId;
    private int productId;
    private String name;
    private int quantity;
    private double price;
    private LocalDate auditDate;

}
