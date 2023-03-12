package com.backend.portfolio.Services.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.CategoryEntity;
import com.backend.portfolio.Models.Repositories.MoneyManagement.categoryRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoryService {

  @Autowired
  private categoryRepo categoryRepo;

  public List<CategoryEntity> findAll() {
    return categoryRepo.findAll();
  }

  public CategoryEntity addCategory(CategoryEntity categoryEntity) {
    categoryEntity.setName(categoryEntity.getName());

    return categoryRepo.save(categoryEntity);
  }
}
