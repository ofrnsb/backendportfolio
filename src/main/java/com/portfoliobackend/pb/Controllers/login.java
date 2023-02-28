package com.portfoliobackend.pb.Controllers;

import com.portfoliobackend.pb.DTO.responseData;
import com.portfoliobackend.pb.Models.Entities.registerEntity;
import com.portfoliobackend.pb.Models.Repositories.loginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class login {

  @Autowired
  private loginRepo loginRepo;

  @PostMapping
  public ResponseEntity<responseData<String>> loginRequest(
    @RequestBody registerEntity user
  ) {
    responseData<String> response = new responseData<>();
    registerEntity existingUser = loginRepo
      .findByUsernameAndPassword(user.getUsername(), user.getPassword())
      .orElse(null);
    if (existingUser == null) {
      response.setMessage("Username or Password is incorrect");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    } else if (!existingUser.getPassword().equals(user.getPassword())) {
      response.setMessage("Username or Password is incorrect");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    } else {
      response.setMessage("Login Success");
      return ResponseEntity.ok(response);
    }
  }
}
