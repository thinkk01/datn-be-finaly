package com.datn.be.service;

import com.datn.be.domain.dto.ReqUpdateAccountDetailDto;
import com.datn.be.entity.AccountDetail;

public interface AccountDetailService {
    AccountDetail findAccountDetail(Long id);

    AccountDetail save(AccountDetail accountDetail);
    AccountDetail update(ReqUpdateAccountDetailDto reqUpdateAccountDetailDto);
    void update(AccountDetail accountDetail);

    AccountDetail findAccountDetailByEmail(String email);
}
