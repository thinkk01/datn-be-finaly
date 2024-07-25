package com.datn.be.domain.dto;

import com.datn.be.entity.Account;
import com.datn.be.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RespOrderDto {
    private Long id;
    private String fullname;
    private String phone;
    private String address;
    private Double total;
    private String note;
    private Date shipDate;
    private LocalDate createDate;
    private Boolean isPending;
    private Account account;
    private OrderStatus orderStatus;
}
