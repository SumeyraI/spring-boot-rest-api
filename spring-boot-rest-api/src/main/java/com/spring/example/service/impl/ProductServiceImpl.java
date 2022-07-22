package com.spring.example.service.impl;

import com.spring.example.dto.ProductDto;
import com.spring.example.dto.UserDto;
import com.spring.example.entities.Product;
import com.spring.example.entities.User;
import com.spring.example.repository.ProductRepository;
import com.spring.example.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=modelMapper.map(productDto,Product.class);
        product.setCreatedAt(new Date());
        return modelMapper.map(productRepository.save(product),ProductDto.class);

    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productDtoList=productRepository.findAll();
        List<ProductDto> userDtos =productDtoList.stream().map(allProduct -> modelMapper.map(allProduct,ProductDto.class)).collect(Collectors.toList());
        return userDtos;
    }


}
