package com.datn.be.service;

import com.datn.be.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {

    Page<Brand> getBrands(Pageable pageable);

    Integer getToTalPage();


    Brand getBrandById(Long id);

    boolean existsByName(String name);

    Brand saveBrand(Brand brand);

    Brand update(Brand brand);

    void delete(Long id);
}
