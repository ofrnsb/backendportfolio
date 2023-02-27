package com.portfoliobackend.pb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoliobackend.pb.Models.Entities.registerEntity;
import com.portfoliobackend.pb.Models.Repositories.loginRepo;

@RestController
@RequestMapping("/login")
public class login {

  @Autowired
  private loginRepo loginRepo;

  @PostMapping
  public ResponseEntity<String> loginRequest(@RequestBody registerEntity user) {
    registerEntity existingUser = loginRepo
      .findByUsernameAndPassword(user.getUsername(), user.getPassword())
      .orElse(null);
    if (existingUser == null) {
      return new ResponseEntity<>(
        "Invalid username or password",
        HttpStatus.UNAUTHORIZED
      );
    } else if (!existingUser.getPassword().equals(user.getPassword())) {
      return new ResponseEntity<>(
        "Invalid username or password",
        HttpStatus.UNAUTHORIZED
      );
    } else {
      return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }
  }
}

