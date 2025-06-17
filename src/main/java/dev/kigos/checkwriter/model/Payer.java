package dev.kigos.checkwriter.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

  @Column(name = "notes")
  private String notes;

  @OneToMany(mappedBy = "payer")
  private List<Check> checks;

}
