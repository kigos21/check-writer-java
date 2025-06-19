package dev.kigos.checkwriter.dto.mapper;

import dev.kigos.checkwriter.dto.PayerDto;
import dev.kigos.checkwriter.model.Payer;

public class PayerDtoMapper {

  public static Payer toEntity(PayerDto dto) {
    if (dto == null) {
      return null;
    }

    Payer ent = new Payer();
    ent.setId(dto.getId());
    ent.setCreatedAt(dto.getCreatedAt());
    ent.setUpdatedAt(dto.getUpdatedAt());
    ent.setName(dto.getName());
    ent.setNotes(dto.getNotes());
    return ent;
  }

  public static PayerDto toDto(Payer ent) {
    if (ent == null) {
      return null;
    }

    PayerDto dto = new PayerDto();
    dto.setId(ent.getId());
    dto.setCreatedAt(ent.getCreatedAt());
    dto.setUpdatedAt(ent.getUpdatedAt());
    dto.setName(ent.getName());
    dto.setNotes(ent.getNotes());
    return dto;
  }

}
