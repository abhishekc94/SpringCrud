package com.abhi.example.repositories;

import com.abhi.example.entity.ProductAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAuditRepository extends JpaRepository<ProductAudit,Integer> {
}
