package com.backend.portfolio.Services.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.CategoryEntity;
import com.backend.portfolio.Models.Repositories.MoneyManagement.categoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoryService {

  @Autowired
  private categoryRepo categoryRepo;

  public CategoryEntity addCategory(CategoryEntity categoryEntity) {
    categoryEntity.setName(categoryEntity.getName());

    return categoryRepo.save(categoryEntity);
  }
}
