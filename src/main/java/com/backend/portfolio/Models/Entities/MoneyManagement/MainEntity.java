package com.backend.portfolio.Models.Entities.MoneyManagement;

import com.backend.portfolio.Models.Entities.registerEntity;
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
@Table(name = "tbl_main")
public class MainEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "amount", nullable = false)
  private Long Amount;

  @Column(name = "create_at", nullable = false, updatable = false)
  @CreationTimestamp
  private Date CreateAt;

  @Column(name = "note", nullable = true)
  private String Note;

  @ManyToOne
  private KindEntity kind;

  @ManyToOne
  private registerEntity registerEntity;

  @ManyToOne
  private CategoryEntity category;

  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }

  public KindEntity getKind() {
    return kind;
  }

  public void setKind(KindEntity kind) {
    this.kind = kind;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAmount() {
    return Amount;
  }

  public void setAmount(Long amount) {
    Amount = amount;
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
}
