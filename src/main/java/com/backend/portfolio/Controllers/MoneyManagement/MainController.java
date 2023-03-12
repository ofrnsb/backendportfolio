package com.backend.portfolio.Controllers.MoneyManagement;

import com.backend.portfolio.DTO.responseData;
import com.backend.portfolio.Models.Entities.MoneyManagement.MainEntity;
import com.backend.portfolio.Services.MoneyManagement.mainService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moneymanagement")
@CrossOrigin(origins = "*")
public class MainController {

  @Autowired
  private mainService mainService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping
  public List<MainEntity> getAll() {
    return mainService.findAll();
  }

  @PostMapping
  public ResponseEntity<responseData<MainEntity>> createMain(
    @RequestBody MainEntity mainEntity
  ) {
    responseData<MainEntity> response = new responseData<>();
    modelMapper.map(mainEntity, MainEntity.class);

    mainService.saveData(mainEntity);

    response.setMessage("Add Name Success");
    return ResponseEntity.ok(response);
  }
}
