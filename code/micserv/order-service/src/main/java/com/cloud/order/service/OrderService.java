package com.cloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.order.entity.Orders;
import com.cloud.order.entity.OrdersDto;

public interface OrderService extends IService<Orders> {
    OrdersDto getByIdWithUser(Long orderId);
}
