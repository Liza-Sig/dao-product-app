package com.example.dao_product_app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String getProductName(String name) {
        List<String> products = entityManager.createQuery(
                "SELECT o.productName FROM Order o " +
                        "JOIN o.customer c " +
                        " WHERE LOWER(c.name) = LOWER(:name)",
                String.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultList();
        return products.isEmpty() ? null : products.get(0);
    }
}
