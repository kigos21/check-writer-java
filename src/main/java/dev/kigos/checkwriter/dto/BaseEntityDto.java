package dev.kigos.checkwriter.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class BaseEntityDto {
  private String id;
  private Instant createdAt;
  private Instant updatedAt;
}
