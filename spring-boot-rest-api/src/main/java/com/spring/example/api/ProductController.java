package com.spring.example.api;

import com.spring.example.dto.ProductDto;
import com.spring.example.service.IProductService;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final IProductService iProductService;


    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(iProductService.createProduct(productDto));

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtoList= iProductService.getAllProduct();
        return ResponseEntity.ok(productDtoList);

    }

    @GetMapping({"/findByModel/{name}"})
    private ResponseEntity<ProductDto> findByModel(@PathVariable ("name") String name){
        ProductDto productDto= iProductService.findByModel(name);
        return ResponseEntity.ok(productDto);
    }



}
