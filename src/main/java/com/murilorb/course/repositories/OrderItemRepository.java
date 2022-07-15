package com.murilorb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilorb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
