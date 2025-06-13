package dev.kigos.checkwriter.dto.request;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCheckDto {

  @NotNull(message = "Date is required")
  private Instant date;

  @NotNull(message = "Payee is required")
  @NotBlank(message = "Payee must not be blank")
  private String payeeId;

  @NotNull(message = "Amount is required")
  @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
  private BigDecimal amount;

  @NotNull(message = "Payer is required")
  @NotBlank(message = "Payer must not be blank")
  private String payerId;

}
