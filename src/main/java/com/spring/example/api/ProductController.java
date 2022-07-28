package com.spring.example.api;

import com.spring.example.dto.CategoryDto;
import com.spring.example.dto.ProductDto;
import com.spring.example.dto.UserDto;
import com.spring.example.entities.Product;
import com.spring.example.repository.ProductRepository;
import com.spring.example.service.IProductService;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService iProductService;


    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto productDto1=iProductService.createProduct(productDto);
        return ResponseEntity.ok(productDto1);

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtoList= iProductService.getAllProduct();
        return ResponseEntity.ok(productDtoList);

    }
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable ("id") Long id ){

        iProductService.deleteProduct(id);
    }

    @PutMapping({"/updateProduct/{id}"})
    public ResponseEntity<ProductDto> updateProduct(@PathVariable ("id") Long id, @RequestBody ProductDto productDto){

        ProductDto updatedProduct=iProductService.updateProduct(id,productDto);
        return ResponseEntity.ok(updatedProduct);

    }

}
