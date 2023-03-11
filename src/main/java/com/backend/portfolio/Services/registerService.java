package com.backend.portfolio.Services;

import com.backend.portfolio.Models.Entities.registerEntity;
import com.backend.portfolio.Models.Repositories.registerRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class registerService {

  @Autowired
  private registerRepo registerRepo;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public List<registerEntity> findAll() {
    return registerRepo.findAll();
  }

  public registerEntity registerUser(registerEntity user) {
    if (user.getUsername().isBlank() || user.getCompanyName().isBlank()) {
      throw new RuntimeException("Username or password cannot be blank");
    } else if (user.getUsername().length() < 6) {
      throw new RuntimeException("Username must be at least 6 characters");
    } else if (user.getPassword().length() < 8) {
      throw new RuntimeException("Password must be at least 8 characters");
    } else if (
      !user.getPassword().matches("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9]).+$")
    ) {
      throw new RuntimeException(
        "Password must contain at least one uppercase letter, one special character, and one number"
      );
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
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      return registerRepo.save(user);
    }
  }
}
