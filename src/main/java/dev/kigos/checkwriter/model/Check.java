package dev.kigos.checkwriter.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "checks")
public class Check {
  private String id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
