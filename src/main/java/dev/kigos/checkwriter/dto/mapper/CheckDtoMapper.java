package dev.kigos.checkwriter.dto.mapper;

import org.springframework.stereotype.Component;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;
import dev.kigos.checkwriter.model.Check;

@Component
public class CheckDtoMapper {

  private final PayerDtoMapper payerDtoMapper;
  private final PayeeDtoMapper payeeDtoMapper;

  public CheckDtoMapper(PayerDtoMapper payerDtoMapper, PayeeDtoMapper payeeDtoMapper) {
    this.payerDtoMapper = payerDtoMapper;
    this.payeeDtoMapper = payeeDtoMapper;
  }

  public Check toEntity(CreateCheckDto createCheckDto) {
    if (createCheckDto == null) {
      return null;
    }

    Check check = new Check();
    check.setPayerId(createCheckDto.getPayerId());
    check.setPayeeId(createCheckDto.getPayeeId());
    check.setDate(createCheckDto.getDate());
    check.setAmount(createCheckDto.getAmount());
    return check;
  }

  public CheckDto toDto(Check check) {
    if (check == null) {
      return null;
    }

    CheckDto checkDto = new CheckDto();
    checkDto.setId(check.getId());
    checkDto.setCreatedAt(check.getCreatedAt());
    checkDto.setUpdatedAt(check.getUpdatedAt());
    checkDto.setPayerId(check.getPayerId());
    checkDto.setPayeeId(check.getPayeeId());
    // checkDto.setPayee(payeeDtoMapper.toDto(check.getPayee()));
    checkDto.setDate(check.getDate());
    checkDto.setAmount(check.getAmount());
    return checkDto;
  }

  public CheckDto toDtoWithPayee(Check check) {
    if (check == null) {
      return null;
    }

    CheckDto checkDto = this.toDto(check);
    checkDto.setPayee(payeeDtoMapper.toDto(check.getPayee()));
    return checkDto;
  }

  public CheckDto toDtoWithPayer(Check check) {
    if (check == null) {
      return null;
    }

    CheckDto checkDto = this.toDto(check);
    checkDto.setPayer(payerDtoMapper.toDto(check.getPayer()));
    return checkDto;
  }

  public CheckDto toDtoWithPayerAndPayee(Check check) {
    if (check == null) {
      return null;
    }

    CheckDto checkDto = this.toDto(check);
    checkDto.setPayee(payeeDtoMapper.toDto(check.getPayee()));
    checkDto.setPayer(payerDtoMapper.toDto(check.getPayer()));
    return checkDto;
  }

}
