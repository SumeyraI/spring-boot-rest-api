package com.spring.example.service;

import com.spring.example.dto.ProductDto;
import java.util.List;

public interface IProductService {

      void deleteProduct(Long id);

    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProduct();


    ProductDto updateProduct(Long id, ProductDto productDto);
}
