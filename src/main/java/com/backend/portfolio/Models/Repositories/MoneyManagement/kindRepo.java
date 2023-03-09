package com.backend.portfolio.Models.Repositories.MoneyManagement;

import com.backend.portfolio.Models.Entities.MoneyManagement.Kind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface kindRepo extends JpaRepository<Kind, Long> {}
