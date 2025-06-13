package dev.kigos.checkwriter.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDto {
  private String id;
  private Instant createdAt;
  private Instant updatedAt;

  private String payerId;
  private String payeeId;
  private Instant date;
  private BigDecimal amount;
}
