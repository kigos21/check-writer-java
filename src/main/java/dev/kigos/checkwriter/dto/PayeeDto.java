package dev.kigos.checkwriter.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PayeeDto extends BaseEntityDto {
  private String name;
  private List<CheckDto> checks;
}
