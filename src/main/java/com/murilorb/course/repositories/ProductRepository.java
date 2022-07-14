package com.murilorb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilorb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
