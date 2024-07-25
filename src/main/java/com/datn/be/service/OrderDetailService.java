package com.datn.be.service;

import com.datn.be.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getAllByOrderId(Long id);
}
