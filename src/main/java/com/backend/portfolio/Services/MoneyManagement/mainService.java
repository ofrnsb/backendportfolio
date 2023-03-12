package com.backend.portfolio.Services.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.MainEntity;
import com.backend.portfolio.Models.Repositories.MoneyManagement.mainRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mainService {

  @Autowired
  private mainRepo mainRepo;

  public List<MainEntity> findAll() {
    return mainRepo.findAll();
  }

  public MainEntity saveData(MainEntity mainEntity) {
    return mainRepo.save(mainEntity);
  }
}
