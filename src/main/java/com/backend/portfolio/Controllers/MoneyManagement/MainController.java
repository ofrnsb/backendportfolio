package com.backend.portfolio.Controllers.MoneyManagement;

import com.backend.portfolio.DTO.responseData;
import com.backend.portfolio.Models.Entities.MoneyManagement.MainEntity;
import com.backend.portfolio.Services.MoneyManagement.mainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money-management")
@CrossOrigin(origins = "*")
public class MainController {

  @Autowired
  private mainService mainService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<responseData<String>> createMain(
    @RequestBody MainEntity mainEntity
  ) {
    responseData<String> response = new responseData<>();

    mainService.addAmount(modelMapper.map(mainEntity, MainEntity.class));

    response.setMessage("Login Success");
    return ResponseEntity.ok(response);
  }
}
