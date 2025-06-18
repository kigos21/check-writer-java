package dev.kigos.checkwriter.dto.mapper;

import org.springframework.stereotype.Component;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CheckRequestDto;
import dev.kigos.checkwriter.model.Check;

@Component
public class CheckDtoMapper {

  private final PayerDtoMapper payerDtoMapper;
  private final PayeeDtoMapper payeeDtoMapper;

  public CheckDtoMapper(PayerDtoMapper payerDtoMapper, PayeeDtoMapper payeeDtoMapper) {
    this.payerDtoMapper = payerDtoMapper;
    this.payeeDtoMapper = payeeDtoMapper;
  }

  public Check toEntity(CheckRequestDto dto) {
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

  public CheckDto toDto(Check ent) {
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

  public CheckDto toDtoWithPayee(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = this.toDto(ent);
    dto.setPayee(payeeDtoMapper.toDto(ent.getPayee()));
    return dto;
  }

  public CheckDto toDtoWithPayer(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = this.toDto(ent);
    dto.setPayer(payerDtoMapper.toDto(ent.getPayer()));
    return dto;
  }

  public CheckDto toDtoWithPayerAndPayee(Check ent) {
    if (ent == null) {
      return null;
    }

    CheckDto dto = this.toDto(ent);
    dto.setPayee(payeeDtoMapper.toDto(ent.getPayee()));
    dto.setPayer(payerDtoMapper.toDto(ent.getPayer()));
    return dto;
  }

}
