package com.datn.be.service.impl;

import com.datn.be.repo.RoleRepo;
import com.datn.be.entity.Role;
import com.datn.be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    @Override
    public Role findById(Long id) {
        return roleRepo.findById(id).get();
    }
}
