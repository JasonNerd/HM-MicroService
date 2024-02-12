package com.cloud.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.order.entity.Orders;
import com.cloud.order.entity.OrdersDto;
import com.cloud.order.entity.Result;
import com.cloud.order.entity.User;
import com.cloud.order.mapper.OrderMapper;
import com.cloud.order.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OrdersDto getByIdWithUser(Long orderId) {
        Orders orders = getById(orderId);
        OrdersDto dto = new OrdersDto();
        BeanUtils.copyProperties(orders, dto);
        // 构造 url 以进行远程调用
        String url = "http://localhost:8082/user/"+dto.getUserId();
        Result result = restTemplate.getForObject(url, Result.class);
//        System.out.println(result.getData().getClass().getSimpleName());
        User user = new ObjectMapper().convertValue(result.getData(), User.class);
        dto.setUser(user);
        return dto;
    }
}
