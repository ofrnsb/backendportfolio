package com.backend.portfolio.Controllers.MoneyManagement;

import com.backend.portfolio.DTO.responseData;
import com.backend.portfolio.Models.Entities.MoneyManagement.CategoryEntity;
import com.backend.portfolio.Services.MoneyManagement.categoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Category")
@CrossOrigin("*")
public class CategoryController {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private categoryService categoryService;

  @PostMapping
  public ResponseEntity<responseData<String>> createKind(
    @RequestBody CategoryEntity categoryEntity
  ) {
    responseData<String> response = new responseData<>();

    categoryService.addCategory(
      modelMapper.map(categoryEntity, CategoryEntity.class)
    );

    response.setMessage("Add Category Success");
    return ResponseEntity.ok(response);
  }
}
