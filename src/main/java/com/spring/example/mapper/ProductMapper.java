package com.spring.example.mapper;

import com.spring.example.dto.ProductDto;
import com.spring.example.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToDto(Product product);

    Product DtoToProduct(ProductDto productDto);
}
