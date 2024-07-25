package com.datn.be.service.impl;

import com.datn.be.entity.OrderStatus;
import com.datn.be.repo.OrderStatusRepo;
import com.datn.be.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    OrderStatusRepo orderStatusRepo;
    @Override
    public OrderStatus getById(Long id) {
        Optional<OrderStatus> optional = orderStatusRepo.findById(id);
        if(!optional.isPresent()){
            return null;
        }
        return optional.get();
    }

    @Override
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepo.findAll();
    }
}
