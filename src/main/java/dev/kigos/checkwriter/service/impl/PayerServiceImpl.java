package dev.kigos.checkwriter.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.kigos.checkwriter.dto.PayerDto;
import dev.kigos.checkwriter.dto.mapper.PayerDtoMapper;
import dev.kigos.checkwriter.dto.request.PayerRequestDto;
import dev.kigos.checkwriter.exception.EntityInUseException;
import dev.kigos.checkwriter.model.Payer;
import dev.kigos.checkwriter.repository.PayerRepository;
import dev.kigos.checkwriter.service.PayerService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PayerServiceImpl implements PayerService {

  private final PayerRepository payerRepository;

  public PayerServiceImpl(PayerRepository payerRepository) {
    this.payerRepository = payerRepository;
  }

  @Override
  public PayerDto createPayer(PayerRequestDto payerRequestDto) {
    Payer payer = PayerDtoMapper.toEntity(payerRequestDto);
    payer = payerRepository.save(payer);
    return PayerDtoMapper.toDto(payer);
  }

  @Override
  public List<PayerDto> getPayers() {
    Sort sort = Sort.by("createdAt").descending();
    List<Payer> payers = payerRepository.findAll(sort);
    return payers.stream().map(PayerDtoMapper::toDto).toList();
  }

  @Override
  public PayerDto updatePayer(String payerId, PayerRequestDto payerRequestDto) {
    Payer payer = payerRepository.findById(payerId)
        .orElseThrow(() -> new EntityNotFoundException("Payer with id " + payerId + " not found"));
    payer.setName(payerRequestDto.getName());
    payer.setNotes(payerRequestDto.getNotes());
    payer = payerRepository.save(payer);
    return PayerDtoMapper.toDto(payer);
  }

  @Override
  public PayerDto deletePayer(String payerId) {
    Payer payer = payerRepository.findById(payerId)
        .orElseThrow(() -> new EntityNotFoundException("Payer with id " + payerId + " not found"));
    if (!payer.getChecks().isEmpty()) {
      throw new EntityInUseException("Cannot delete payer. It is referenced by existing checks.");
    }
    payerRepository.delete(payer);
    return PayerDtoMapper.toDto(payer);
  }

}
