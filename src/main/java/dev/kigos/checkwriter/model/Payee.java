package dev.kigos.checkwriter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "payees")
@EqualsAndHashCode(callSuper = false)
public class Payee extends BaseEntity {

  @Column(name = "name", nullable = false)
  private String name;

}
