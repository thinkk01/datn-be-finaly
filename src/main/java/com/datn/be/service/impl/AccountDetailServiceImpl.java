package com.datn.be.service.impl;

import com.datn.be.domain.dto.ReqUpdateAccountDetailDto;
import com.datn.be.entity.AccountDetail;
import com.datn.be.repo.AccountDetailRepo;
import com.datn.be.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {
    @Autowired
    AccountDetailRepo accountDetailRepo;
    @Override
    public AccountDetail findAccountDetail(Long id) {
        return accountDetailRepo.findAccountDetailByAccount_Id(id);
    }

    @Override
    public AccountDetail save(AccountDetail accountDetail) {
        return this.accountDetailRepo.save(accountDetail);
    }

    @Override
    public AccountDetail update(ReqUpdateAccountDetailDto reqUpdateAccountDetailDto) {
        AccountDetail accountDetail = findAccountDetail(reqUpdateAccountDetailDto.getId());
        accountDetail.setFullname(reqUpdateAccountDetailDto.getFullname());
        accountDetail.setPhone(reqUpdateAccountDetailDto.getPhone());
        accountDetail.setEmail(reqUpdateAccountDetailDto.getEmail());
        accountDetail.setAddress(reqUpdateAccountDetailDto.getAddress());
        accountDetail.setGender(reqUpdateAccountDetailDto.getGender());
        return accountDetailRepo.save(accountDetail);
    }


    @Override
    public void update(AccountDetail accountDetail) {
        this.accountDetailRepo.update(accountDetail.getFullname(), accountDetail.getGender(), accountDetail.getPhone(), accountDetail.getEmail(), accountDetail.getAddress(), accountDetail.getBirthDate(), accountDetail.getAccount().getId());
    }

    @Override
    public AccountDetail findAccountDetailByEmail(String email) {
        return this.accountDetailRepo.findAccountDetailByEmail(email);
    }


}
