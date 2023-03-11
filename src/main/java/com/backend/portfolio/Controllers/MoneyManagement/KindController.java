package com.backend.portfolio.Controllers.MoneyManagement;

import com.backend.portfolio.DTO.responseData;
import com.backend.portfolio.Models.Entities.MoneyManagement.KindEntity;
import com.backend.portfolio.Services.MoneyManagement.kindService;
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
@RequestMapping("/kind")
@CrossOrigin("*")
public class KindController {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private kindService kindService;

  @GetMapping
  public List<KindEntity> getAll() {
    return kindService.findAll();
  }

  @PostMapping
  public ResponseEntity<responseData<String>> createKind(
    @RequestBody KindEntity kindEntity
  ) {
    responseData<String> response = new responseData<>();

    kindService.addKind(modelMapper.map(kindEntity, KindEntity.class));

    response.setMessage("Add Kind Success");
    return ResponseEntity.ok(response);
  }
}
