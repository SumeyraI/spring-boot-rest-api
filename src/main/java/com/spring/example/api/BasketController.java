package com.spring.example.api;

import com.spring.example.dto.ProductDto;
import com.spring.example.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {


    private final IProductService productService;

    public BasketController(IProductService productService) {

        this.productService = productService;
    }

    @GetMapping({"/getAllProductInBasket/{id}"})
    public ResponseEntity<ProductDto> getAllProductInBasket(@PathVariable ("id") Long id){

        ProductDto basketDto=productService.getProductById(id);
        return ResponseEntity.ok(basketDto);
    }

}
