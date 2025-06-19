package dev.kigos.checkwriter.service;

import java.util.List;

import dev.kigos.checkwriter.dto.PayerDto;
import dev.kigos.checkwriter.dto.request.PayerRequestDto;

public interface PayerService {

  PayerDto createPayer(PayerRequestDto payerRequestDto);

  List<PayerDto> getPayers();

  PayerDto updatePayer(String payerId, PayerRequestDto payerRequestDto);

  PayerDto deletePayer(String payerId);

}
