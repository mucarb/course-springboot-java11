package com.murilorb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilorb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
