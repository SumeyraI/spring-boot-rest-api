package com.spring.example.service;

import com.spring.example.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    List<CategoryDto> findAll();

    void deleteCategory(Long id);

    CategoryDto getByCode(Integer code);

    List<CategoryDto> getByCodeAllCategory(Integer code);

    void deleteByCodes(Integer code);

    CategoryDto updateCategoryById(Long id, CategoryDto categoryDto);
}
