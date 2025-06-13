package dev.kigos.checkwriter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "payers")
@EqualsAndHashCode(callSuper = false)
public class Payer extends BaseEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "notes", nullable = false)
  private String notes;

}
