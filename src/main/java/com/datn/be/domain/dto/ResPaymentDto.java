package com.datn.be.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResPaymentDto implements Serializable {
    private String status;
    private String message;
    private String URL;
}
