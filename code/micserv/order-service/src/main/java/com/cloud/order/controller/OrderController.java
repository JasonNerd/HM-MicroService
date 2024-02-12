package com.cloud.order.controller;

import com.cloud.order.entity.Orders;
import com.cloud.order.entity.OrdersDto;
import com.cloud.order.entity.Result;
import com.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public Result<OrdersDto> getById(@PathVariable Long orderId){
        log.info("get order details by {}", orderId);
        OrdersDto dto = orderService.getByIdWithUser(orderId);
        return Result.success(dto);
    }
}
