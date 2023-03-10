package com.backend.portfolio.Models.Repositories.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepo extends JpaRepository<CategoryEntity, Long> {}
