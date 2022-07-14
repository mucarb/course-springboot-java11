package com.murilorb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilorb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
