package com.spring.example.service;

import com.spring.example.dto.ProductDto;

public interface IBasketService {
    ProductDto findProductById(Long id);
}
