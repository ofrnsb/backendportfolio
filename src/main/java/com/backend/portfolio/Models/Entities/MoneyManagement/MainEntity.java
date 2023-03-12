package com.backend.portfolio.Models.Entities.MoneyManagement;

import com.backend.portfolio.Models.Entities.registerEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_main")
public class MainEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "mainName", nullable = false)
  private String mainName;

  @ManyToOne
  @JsonBackReference //FOR THE OWNED SIDE
  private registerEntity registerEntity;

  public registerEntity getRegisterEntity() {
    return registerEntity;
  }

  public void setRegisterEntity(registerEntity registerEntity) {
    this.registerEntity = registerEntity;
  }

  @OneToMany(mappedBy = "mainEntity")
  @JsonManagedReference
  private List<CategoryEntity> category;

  public MainEntity() {
    this.category = new ArrayList<>(); // inisialisasi list category pada konstruktor
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMainName() {
    return mainName;
  }

  public void setMainName(String mainName) {
    this.mainName = mainName;
  }

  public List<CategoryEntity> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryEntity> category) {
    this.category = category;
  }
}
