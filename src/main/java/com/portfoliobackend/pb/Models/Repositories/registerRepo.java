package com.portfoliobackend.pb.Models.Repositories;

import com.portfoliobackend.pb.Models.Entities.registerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface registerRepo extends JpaRepository<registerEntity, Long> {
  @Query(
    "SELECT p FROM registerEntity p WHERE p.username = :username AND p.CompanyName = :CompanyName"
  )
  public Optional<registerEntity> findByNameAndCompanyName(
    @Param("username") String username,
    @Param("CompanyName") String CompanyName
  );
}
