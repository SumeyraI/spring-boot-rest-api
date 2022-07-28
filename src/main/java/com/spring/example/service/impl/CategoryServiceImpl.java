package com.spring.example.service.impl;

import com.spring.example.dto.CategoryDto;
import com.spring.example.entities.Category;
import com.spring.example.exception.NotFoundException;
import com.spring.example.repository.CategoryRepository;
import com.spring.example.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {

        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {

        Category category=modelMapper.map(categoryDto,Category.class);

        return modelMapper.map(categoryRepository.save(category),CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAll() {

        List<Category> categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtos =categories.stream().map(category -> modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;

    }
    @Override
    public void deleteCategory(Long id) {

        Category category=categoryRepository.findById(id).orElseThrow(()->new NotFoundException("The category which you want to delete doesn't found"));
        categoryRepository.deleteById(id);

    }
    @Override
    public CategoryDto getByCode(Integer code) {
        Optional<Category> getByCategory = categoryRepository.findByCode(code);
        if (getByCategory.isPresent()){
            return modelMapper.map(getByCategory.get(),CategoryDto.class);
        }
        return null;
    }

    @Override
    public List<CategoryDto> getByCodeAllCategory(Integer code) {
        List<Category> categories=categoryRepository.findAllByCode(code);
        List<CategoryDto> categoryDtos =categories.stream().map(category -> modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());

        return categoryDtos;
    }

    @Override
    @Transactional
    public void deleteByCodes(Integer code) {
        Category category=categoryRepository.findByCode(code).orElseThrow(()->new NotFoundException("The code which you want to delete doesn't found"));
        categoryRepository.deleteByCode(code);
    }

    @Override
    public CategoryDto updateCategoryById(Long id, CategoryDto categoryDto) {

        Category category=categoryRepository.findById(id).orElseThrow(()->new NotFoundException("The code which you want to delete doesn't found"));

        category.setCategoryName(categoryDto.getCategoryName());
        category.setCode(categoryDto.getCode());
        category.setUpdatedBy(categoryDto.getUpdatedBy());

        return modelMapper.map(categoryRepository.save(category),CategoryDto.class);

    }


}
