package com.backend.portfolio.Controllers;

import com.backend.portfolio.DTO.registerData;
import com.backend.portfolio.DTO.responseData;
import com.backend.portfolio.Models.Entities.registerEntity;
import com.backend.portfolio.Services.registerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class register {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private registerService registerService;

  @PostMapping
  public ResponseEntity<responseData<registerEntity>> login(
    @Valid @RequestBody registerData registerData,
    Errors errors
  ) {
    responseData<registerEntity> response = new responseData<>();

    try {
      registerService.registerUser(
        modelMapper.map(registerData, registerEntity.class)
      );
    } catch (RuntimeException e) {
      response.setMessage(e.getMessage());
      return ResponseEntity.status(401).body(response);
    }

    response.setMessage("Register Success");
    return ResponseEntity.ok(response);
  }
}
