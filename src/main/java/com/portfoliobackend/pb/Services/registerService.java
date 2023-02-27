package com.portfoliobackend.pb.Services;

import com.portfoliobackend.pb.Models.Entities.registerEntity;
import com.portfoliobackend.pb.Models.Repositories.registerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class registerService {

  @Autowired
  private registerRepo registerRepo;

  public registerEntity registerUser(registerEntity user) {
    boolean isExist = registerRepo
      .findByNameAndCompanyName(user.getUsername(), user.getCompanyName())
      .isPresent();

    if (isExist) {
      throw new ResponseStatusException(
        HttpStatus.INTERNAL_SERVER_ERROR,
        String.format(
          "Username %s with company %s is already registered",
          user.getUsername(),
          user.getCompanyName()
        )
      );
    } else {
      user.setCompanyName(user.getCompanyName());
      user.setUsername(user.getUsername());
      user.setPassword(user.getPassword());
      return registerRepo.save(user);
    }
  }
}
