package dev.kigos.checkwriter.dto.mapper;

import org.springframework.stereotype.Component;

import dev.kigos.checkwriter.dto.PayeeDto;
import dev.kigos.checkwriter.model.Payee;

@Component
public class PayeeDtoMapper {

  public Payee toEntity(PayeeDto dto) {
    if (dto == null) {
      return null;
    }

    Payee ent = new Payee();
    ent.setId(dto.getId());
    ent.setCreatedAt(dto.getCreatedAt());
    ent.setUpdatedAt(dto.getUpdatedAt());
    ent.setName(dto.getName());
    return ent;
  }

  public PayeeDto toDto(Payee ent) {
    if (ent == null) {
      return null;
    }

    PayeeDto dto = new PayeeDto();
    dto.setId(ent.getId());
    dto.setCreatedAt(ent.getCreatedAt());
    dto.setUpdatedAt(ent.getUpdatedAt());
    dto.setName(ent.getName());
    return dto;
  }

}
