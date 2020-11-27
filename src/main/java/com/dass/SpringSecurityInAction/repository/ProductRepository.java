package com.dass.SpringSecurityInAction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dass.SpringSecurityInAction.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
