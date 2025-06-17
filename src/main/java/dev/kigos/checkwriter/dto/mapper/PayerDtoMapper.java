package dev.kigos.checkwriter.dto.mapper;

import org.springframework.stereotype.Component;

import dev.kigos.checkwriter.dto.PayerDto;
import dev.kigos.checkwriter.model.Payer;

@Component
public class PayerDtoMapper {

  public Payer toEntity(PayerDto payerDto) {
    if (payerDto == null) {
      return null;
    }

    Payer payer = new Payer();
    payer.setId(payerDto.getId());
    payer.setCreatedAt(payerDto.getCreatedAt());
    payer.setUpdatedAt(payerDto.getUpdatedAt());
    payer.setName(payerDto.getName());
    payer.setNotes(payerDto.getNotes());
    return payer;
  }

  public PayerDto toDto(Payer payer) {
    if (payer == null) {
      return null;
    }

    PayerDto payerDto = new PayerDto();
    payerDto.setId(payer.getId());
    payerDto.setCreatedAt(payer.getCreatedAt());
    payerDto.setUpdatedAt(payer.getUpdatedAt());
    payerDto.setName(payer.getName());
    payerDto.setNotes(payer.getNotes());
    return payerDto;
  }

}
