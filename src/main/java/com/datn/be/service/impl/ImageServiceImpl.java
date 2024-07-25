package com.datn.be.service.impl;

import com.datn.be.repo.ImageRepo;
import com.datn.be.entity.Image;
import com.datn.be.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepo imageRepo;

    @Override
    public Image createImage(Image image) {
        return imageRepo.save(image);
    }
}
