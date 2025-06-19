package dev.kigos.checkwriter.dto.mapper;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CheckRequestDto;
import dev.kigos.checkwriter.model.Check;

public class CheckDtoMapper {

  public static Check toEntity(CheckRequestDto dto) {
    if (dto == null) {
      return null;
    }

    Check ent = new Check();
    ent.setPayerId(dto.getPayerId());
    ent.setPayeeId(dto.getPayeeId());
    ent.setDate(dto.getDate());
    ent.setAmount(dto.getAmount());
    return ent;
  }

  public static CheckDto toDto(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = new CheckDto();
    dto.setId(ent.getId());
    dto.setCreatedAt(ent.getCreatedAt());
    dto.setUpdatedAt(ent.getUpdatedAt());
    dto.setPayerId(ent.getPayerId());
    dto.setPayeeId(ent.getPayeeId());
    dto.setDate(ent.getDate());
    dto.setAmount(ent.getAmount());
    return dto;
  }

  public static CheckDto toDtoWithPayee(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = toDto(ent);
    dto.setPayee(PayeeDtoMapper.toDto(ent.getPayee()));
    return dto;
  }

  public static CheckDto toDtoWithPayer(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = toDto(ent);
    dto.setPayer(PayerDtoMapper.toDto(ent.getPayer()));
    return dto;
  }

  public static CheckDto toDtoWithPayerAndPayee(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = toDto(ent);
    dto.setPayee(PayeeDtoMapper.toDto(ent.getPayee()));
    dto.setPayer(PayerDtoMapper.toDto(ent.getPayer()));
    return dto;
  }

}
