package com.portfoliobackend.pb.Services;

import com.portfoliobackend.pb.Models.Entities.registerEntity;
import com.portfoliobackend.pb.Models.Repositories.registerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class registerService {

  @Autowired
  private registerRepo registerRepo;

  public registerEntity registerUser(registerEntity user) {
    if (user.getUsername().isBlank() || user.getCompanyName().isBlank()) {
      throw new RuntimeException("Username or password cannot be blank");
    }

    boolean isExist = registerRepo
      .findByNameAndCompanyName(user.getUsername(), user.getCompanyName())
      .isPresent();

    if (isExist) {
      throw new RuntimeException(
        String.format("The account is already registered")
      );
    } else {
      user.setCompanyName(user.getCompanyName());
      user.setUsername(user.getUsername());
      user.setPassword(user.getPassword());
      return registerRepo.save(user);
    }
  }
}
