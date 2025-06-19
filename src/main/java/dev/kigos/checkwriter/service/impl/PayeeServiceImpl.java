package dev.kigos.checkwriter.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.kigos.checkwriter.dto.PayeeDto;
import dev.kigos.checkwriter.dto.mapper.PayeeDtoMapper;
import dev.kigos.checkwriter.dto.request.PayeeRequestDto;
import dev.kigos.checkwriter.exception.EntityInUseException;
import dev.kigos.checkwriter.model.Payee;
import dev.kigos.checkwriter.repository.PayeeRepository;
import dev.kigos.checkwriter.service.PayeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PayeeServiceImpl implements PayeeService {

  private final PayeeRepository payeeRepository;

  public PayeeServiceImpl(PayeeRepository payeeRepository) {
    this.payeeRepository = payeeRepository;
  }

  @Override
  public PayeeDto createPayee(PayeeRequestDto payeeRequestDto) {
    Payee payee = PayeeDtoMapper.toEntity(payeeRequestDto);
    payeeRepository.save(payee);
    return PayeeDtoMapper.toDto(payee);
  }

  @Override
  public Page<PayeeDto> getPayees(String payeeName, Pageable pageable) {
    Page<Payee> page = payeeRepository.findByNameContainingIgnoreCase(payeeName, pageable);
    return page.map(payee -> PayeeDtoMapper.toDto(payee));
  }

  @Override
  public PayeeDto updatePayee(String payeeId, PayeeRequestDto payeeRequestDto) {
    Payee payee = payeeRepository.findById(payeeId)
        .orElseThrow(() -> new EntityNotFoundException("Payee with id " + payeeId + " not found"));
    payee.setName(payeeRequestDto.getName());
    payee = payeeRepository.save(payee);
    return PayeeDtoMapper.toDto(payee);
  }

  @Override
  public PayeeDto deletePayee(String payeeId) {
    Payee payee = payeeRepository.findById(payeeId)
        .orElseThrow(() -> new EntityNotFoundException("Payee with id " + payeeId + " not found"));
    if (!payee.getChecks().isEmpty()) {
      throw new EntityInUseException("Cannot delete payee. It is referenced by existing checks.");
    }
    payeeRepository.delete(payee);
    return PayeeDtoMapper.toDto(payee);
  }

}
