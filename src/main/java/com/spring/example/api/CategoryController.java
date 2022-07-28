package com.spring.example.api;

import com.spring.example.dto.CategoryDto;
import com.spring.example.entities.Category;
import com.spring.example.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(iCategoryService.addCategory(categoryDto));

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categoryDtos = iCategoryService.findAll();
        return ResponseEntity.ok(categoryDtos);
    }

    @DeleteMapping({"/deleteCategory/{id}"})
    public void deleteCategory(@PathVariable("id") Long id) {

        iCategoryService.deleteCategory(id);
    }

    @GetMapping({"/getByCode/{code}"})
    public ResponseEntity<CategoryDto> getByCode(@PathVariable("code") Integer code) {

        CategoryDto getByCode = iCategoryService.getByCode(code);
        return ResponseEntity.ok(getByCode);
    }

    @GetMapping({"/getByCodes/{code}"})
    public ResponseEntity<List<CategoryDto>> getByCodeAllCategory(@PathVariable("code") Integer code) {
        List<CategoryDto> allCategory = iCategoryService.getByCodeAllCategory(code);
        return ResponseEntity.ok(allCategory);
    }

    @DeleteMapping({"/deleteByCodes/{code}"})
    public void deleteByCodes(@PathVariable("code") Integer code) {
       iCategoryService.deleteByCodes(code);
    }

    @PutMapping({"/updateCategoryById/{id}"})

    public ResponseEntity<CategoryDto> updateCategoryById(@PathVariable ("id") Long id, @RequestBody CategoryDto categoryDto){

        CategoryDto categoryDto1=iCategoryService.updateCategoryById(id,categoryDto);
        return ResponseEntity.ok(categoryDto1);
    }








}
