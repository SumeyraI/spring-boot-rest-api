package com.spring.example.service;

import com.spring.example.dto.ProductDto;
import java.util.List;

public interface IProductService {

    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();


}
