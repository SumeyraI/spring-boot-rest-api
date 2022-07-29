package com.spring.example.service.impl;

import com.spring.example.dto.ProductDto;
import com.spring.example.entities.Product;
import com.spring.example.exception.NotFoundException;
import com.spring.example.repository.BasketRepository;
import com.spring.example.repository.ProductRepository;
import com.spring.example.service.IBasketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements IBasketService {

    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public BasketServiceImpl(BasketRepository basketRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public ProductDto findProductById(Long id) {

        Product product=productRepository.findById(id).orElseThrow(()->new NotFoundException("The product not found"));
        return modelMapper.map(product,ProductDto.class);


    }
}
