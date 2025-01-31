package com.datn.be.repo;

import com.datn.be.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllByOrder_Id(@Param("id") Long id);
}
