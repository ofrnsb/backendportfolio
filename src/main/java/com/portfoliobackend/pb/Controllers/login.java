package com.portfoliobackend.pb.Controllers;

import com.portfoliobackend.pb.DTO.responseData;
import com.portfoliobackend.pb.Models.Entities.registerEntity;
import com.portfoliobackend.pb.Services.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

///
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class login {

  @Autowired
  private loginService loginService;

  @PostMapping
  public ResponseEntity<responseData<String>> loginRequest(
    @RequestBody registerEntity user
  ) {
    responseData<String> response = new responseData<>();

    try {
      loginService.loginUser(user.getUsername(), user.getPassword());
    } catch (RuntimeException e) {
      response.setMessage(e.getMessage());
      return ResponseEntity.status(401).body(response);
    }

    response.setMessage("Login Success");
    return ResponseEntity.ok(response);
  }
}
