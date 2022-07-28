package com.spring.example.api;

import com.spring.example.dto.OrderDto;
import com.spring.example.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService iOrderService;

    public OrderController(IOrderService iOrderService) {

        this.iOrderService = iOrderService;
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<OrderDto>> getAllOrder(){

        List<OrderDto> orderDtos=iOrderService.getAllOrder();
        return ResponseEntity.ok(orderDtos);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto orderDto1=iOrderService.createOrder(orderDto);
        return ResponseEntity.ok(orderDto1);
    }

    @DeleteMapping({"/deleteById/{id}"})
    public void deleteOrder(@PathVariable Long id){
        iOrderService.deleteOrder(id);

    }
}
