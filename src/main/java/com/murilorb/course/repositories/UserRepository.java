package com.murilorb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilorb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
