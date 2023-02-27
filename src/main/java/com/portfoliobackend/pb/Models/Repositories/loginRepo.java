package com.portfoliobackend.pb.Models.Repositories;

import com.portfoliobackend.pb.Models.Entities.registerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loginRepo extends JpaRepository<registerEntity, Long> {
  Optional<registerEntity> findByUsernameAndPassword(
    String username,
    String password
  );

  Optional<registerEntity> findByUsername(String username);
}
