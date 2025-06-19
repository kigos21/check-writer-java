package dev.kigos.checkwriter.dto.mapper;

import java.util.List;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.PayeeDto;
import dev.kigos.checkwriter.dto.request.PayeeRequestDto;
import dev.kigos.checkwriter.model.Payee;

public class PayeeDtoMapper {

  public static Payee toEntity(PayeeDto dto) {
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

  public static Payee toEntity(PayeeRequestDto dto) {
    if (dto == null) {
      return null;
    }

    Payee ent = new Payee();
    ent.setName(dto.getName());
    return ent;
  }

  public static PayeeDto toDto(Payee ent) {
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

  public static PayeeDto toDtoWithChecks(Payee ent) {
    if (ent == null) {
      return null;
    }

    PayeeDto dto = toDto(ent);
    List<CheckDto> checkDtos = ent.getChecks().stream().map(check -> CheckDtoMapper.toDto(check))
        .toList();
    dto.setChecks(checkDtos);
    return dto;
  }

}
