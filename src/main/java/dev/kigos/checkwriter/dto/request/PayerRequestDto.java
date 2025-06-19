package dev.kigos.checkwriter.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PayerRequestDto {

  @NotNull(message = "Name is required")
  @NotBlank(message = "Name must not be blank")
  private String name;

  private String notes;

}
