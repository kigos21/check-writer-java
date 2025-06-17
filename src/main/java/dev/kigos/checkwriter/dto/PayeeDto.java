package dev.kigos.checkwriter.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PayeeDto extends BaseEntityDto {
  private String name;
}
