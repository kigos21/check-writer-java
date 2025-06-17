package dev.kigos.checkwriter.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PayerDto extends BaseEntityDto {
  private String name;
  private String notes;
}
