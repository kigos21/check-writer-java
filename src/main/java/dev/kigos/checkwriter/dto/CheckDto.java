package dev.kigos.checkwriter.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CheckDto extends BaseEntityDto {
  private String payerId;
  private PayerDto payer;
  private String payeeId;
  private PayeeDto payee;
  private Instant date;
  private BigDecimal amount;
}
