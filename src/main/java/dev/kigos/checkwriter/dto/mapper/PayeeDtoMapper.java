package dev.kigos.checkwriter.dto.mapper;

import org.springframework.stereotype.Component;

import dev.kigos.checkwriter.dto.PayeeDto;
import dev.kigos.checkwriter.model.Payee;

@Component
public class PayeeDtoMapper {

  public Payee toEntity(PayeeDto payeeDto) {
    if (payeeDto == null) {
      return null;
    }

    Payee payee = new Payee();
    payee.setId(payeeDto.getId());
    payee.setCreatedAt(payeeDto.getCreatedAt());
    payee.setUpdatedAt(payeeDto.getUpdatedAt());
    payee.setName(payeeDto.getName());
    return payee;
  }

  public PayeeDto toDto(Payee payee) {
    if (payee == null) {
      return null;
    }

    PayeeDto payeeDto = new PayeeDto();
    payeeDto.setId(payee.getId());
    payeeDto.setCreatedAt(payee.getCreatedAt());
    payeeDto.setUpdatedAt(payee.getUpdatedAt());
    payeeDto.setName(payee.getName());
    return payeeDto;
  }

}
