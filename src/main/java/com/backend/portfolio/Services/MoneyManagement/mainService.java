package com.backend.portfolio.Services.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.MainEntity;
import com.backend.portfolio.Models.Repositories.MoneyManagement.mainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mainService {

  @Autowired
  private mainRepo mainRepo;

  public MainEntity addAmount(MainEntity mainEntity) {
    mainEntity.setAmount(mainEntity.getAmount());
    mainEntity.setCreateAt(mainEntity.getCreateAt());
    mainEntity.setNote(mainEntity.getNote());

    return mainRepo.save(mainEntity);
  }
}
