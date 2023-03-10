package com.backend.portfolio.Models.Repositories.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface mainRepo extends JpaRepository<MainEntity, Long> {}
