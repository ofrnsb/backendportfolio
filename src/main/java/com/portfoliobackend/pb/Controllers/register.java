package com.portfoliobackend.pb.Controllers;

import com.portfoliobackend.pb.DTO.registerData;
import com.portfoliobackend.pb.DTO.responseData;
import com.portfoliobackend.pb.Models.Entities.registerEntity;
import com.portfoliobackend.pb.Services.registerService;
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

    registerService.registerUser(
      modelMapper.map(registerData, registerEntity.class)
    );

    response.setMessage("Register Success");
    return ResponseEntity.ok(response);
  }
}
