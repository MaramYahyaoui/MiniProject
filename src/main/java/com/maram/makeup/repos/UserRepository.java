package com.maram.makeup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maram.makeup.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
