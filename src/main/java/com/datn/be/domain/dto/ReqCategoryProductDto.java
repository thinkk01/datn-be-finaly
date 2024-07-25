package com.datn.be.domain.dto;

import com.datn.be.entity.Category;
import com.datn.be.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReqCategoryProductDto {

    private Long id;

    private Category category;

    private Product product;
}
