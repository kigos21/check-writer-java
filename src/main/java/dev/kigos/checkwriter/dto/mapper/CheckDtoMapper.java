package dev.kigos.checkwriter.dto.mapper;

import org.springframework.stereotype.Component;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;
import dev.kigos.checkwriter.model.Check;

@Component
public class CheckDtoMapper {

  public Check toEntity(CreateCheckDto createCheckDto) {
    Check check = new Check();
    check.setPayerId(createCheckDto.getPayerId());
    check.setPayeeId(createCheckDto.getPayeeId());
    check.setDate(createCheckDto.getDate());
    check.setAmount(createCheckDto.getAmount());
    return check;
  }

  public CheckDto toDto(Check check) {
    CheckDto checkDto = new CheckDto(
        check.getId(),
        check.getCreatedAt(),
        check.getUpdatedAt(),
        check.getPayerId(),
        check.getPayeeId(),
        check.getDate(),
        check.getAmount());
    return checkDto;
  }

}
