package com.spring.example.service.impl;

import com.spring.example.dto.OrderDto;
import com.spring.example.entities.Orders;
import com.spring.example.exception.NotFoundException;
import com.spring.example.repository.OrderRepository;
import com.spring.example.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<OrderDto> getAllOrder() {

        List<Orders> orders1=orderRepository.findAll();
        List<OrderDto> orderDtos1=orders1.stream().map(order -> modelMapper.map(order,OrderDto.class)).collect(Collectors.toList());

        return orderDtos1;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Orders order= modelMapper.map(orderDto,Orders.class);
        order=orderRepository.save(order);
        OrderDto orderDto1=modelMapper.map(order,OrderDto.class);
        return orderDto1;
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {

       final Orders orders=orderRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
       orderRepository.deleteById(orders.getId());
    }
}
