package com.spring.example.repository;

import com.spring.example.dto.BasketDto;
import com.spring.example.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {


}
