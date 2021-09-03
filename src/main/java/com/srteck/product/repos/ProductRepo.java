package com.srteck.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srteck.product.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
