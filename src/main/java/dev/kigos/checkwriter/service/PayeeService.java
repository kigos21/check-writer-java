package dev.kigos.checkwriter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.kigos.checkwriter.dto.PayeeDto;
import dev.kigos.checkwriter.dto.request.PayeeRequestDto;

public interface PayeeService {

  PayeeDto createPayee(PayeeRequestDto payeeRequestDto);

  Page<PayeeDto> getPayees(String payeeName, Pageable pageable);

  PayeeDto updatePayee(String payeeId, PayeeRequestDto payeeRequestDto);

  PayeeDto deletePayee(String payeeId);

}
