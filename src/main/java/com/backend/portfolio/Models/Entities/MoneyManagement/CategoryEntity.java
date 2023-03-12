package com.backend.portfolio.Models.Entities.MoneyManagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_category")
public class CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "category_name")
  private String name;

  @Column(name = "amount", nullable = false, columnDefinition = "BIGINT")
  private Long Amount;

  @Column(name = "create_at", nullable = false, updatable = false)
  @CreationTimestamp
  private Date CreateAt;

  @Column(name = "note", nullable = true)
  private String Note;

  @ManyToOne
  @JsonBackReference
  private MainEntity mainEntity;

  public Long getAmount() {
    return Amount;
  }

  public void setAmount(Long amount) {
    Amount = amount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreateAt() {
    return CreateAt;
  }

  public void setCreateAt(Date createAt) {
    CreateAt = createAt;
  }

  public String getNote() {
    return Note;
  }

  public void setNote(String note) {
    Note = note;
  }

  public MainEntity getMainEntity() {
    return mainEntity;
  }

  public void setMainEntity(MainEntity mainEntity) {
    this.mainEntity = mainEntity;
  }
}
