package com.backend.portfolio.Models.Repositories.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepo extends JpaRepository<Category, Long> {}
