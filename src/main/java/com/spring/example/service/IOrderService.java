package com.spring.example.service;

import com.spring.example.dto.OrderDto;
import java.util.List;


public interface IOrderService{
    List<OrderDto> getAllOrder();

    OrderDto createOrder(OrderDto orderDto);

    void deleteOrder(Long id);
}
