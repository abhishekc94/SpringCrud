package com.abhi.example.service;

import com.abhi.example.entity.Product;
import com.abhi.example.entity.ProductAudit;
import com.abhi.example.repositories.ProductAuditRepository;
import com.abhi.example.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAuditRepository productAuditRepository;

    public Product saveProduct(Product product) {
        ProductAudit productAudit = new ProductAudit();
        Product savedProduct =  productRepository.save(product);
        BeanUtils.copyProperties(savedProduct,productAudit);
        productAudit.setAuditDate(LocalDate.now());
        productAuditRepository.save(productAudit);
        return savedProduct;
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
         productRepository.deleteById(id);
        return "product removed successfully";
    }

    public Product updateProduct(Product product) {
        ProductAudit productAudit = new ProductAudit();
        Product existingProduct = productRepository.findById(product.getProductId()).get();
        BeanUtils.copyProperties(product,existingProduct);
        Product savedProduct =  productRepository.save(product);
        BeanUtils.copyProperties(savedProduct,productAudit);
        productAudit.setAuditDate(LocalDate.now());
        productAuditRepository.save(productAudit);
        return savedProduct;
    }
}
