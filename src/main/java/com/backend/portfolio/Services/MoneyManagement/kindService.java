package com.backend.portfolio.Services.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.KindEntity;
import com.backend.portfolio.Models.Repositories.MoneyManagement.kindRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class kindService {

  @Autowired
  private kindRepo kindRepo;

  public List<KindEntity> findAll() {
    return kindRepo.findAll();
  }

  public KindEntity addKind(KindEntity kindEntity) {
    kindEntity.setName(kindEntity.getName());

    return kindRepo.save(kindEntity);
  }
}
