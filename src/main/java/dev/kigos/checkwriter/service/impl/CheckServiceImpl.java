package dev.kigos.checkwriter.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.mapper.CheckDtoMapper;
import dev.kigos.checkwriter.dto.request.CheckRequestDto;
import dev.kigos.checkwriter.model.Check;
import dev.kigos.checkwriter.repository.CheckRepository;
import dev.kigos.checkwriter.service.CheckService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CheckServiceImpl implements CheckService {

  private final CheckDtoMapper checkDtoMapper;
  private final CheckRepository checkRepository;

  public CheckServiceImpl(CheckDtoMapper checkDtoMapper, CheckRepository checkRepository) {
    this.checkDtoMapper = checkDtoMapper;
    this.checkRepository = checkRepository;
  }

  @Override
  public CheckDto createCheck(CheckRequestDto checkRequestDto) {
    Check newCheck = checkDtoMapper.toEntity(checkRequestDto);
    return checkDtoMapper.toDto(checkRepository.save(newCheck));
  }

  @Override
  public Page<CheckDto> getChecks(String payeeName, Pageable pageable) {
    Page<Check> checkPage = checkRepository.findAllWithPayee(payeeName, pageable);
    return checkPage.map(check -> checkDtoMapper.toDtoWithPayee(check));
  }

  @Override
  public CheckDto getCheckById(String checkId) {
    Check check = checkRepository.findById(checkId)
        .orElseThrow(() -> new EntityNotFoundException("Check with id " + checkId + " not found"));
    return checkDtoMapper.toDtoWithPayerAndPayee(check);
  }

  @Override
  public CheckDto updateCheck(String checkId, CheckRequestDto checkRequestDto) {
    Check check = checkRepository.findById(checkId)
        .orElseThrow(() -> new EntityNotFoundException("Check with id " + checkId + " not found"));
    check.setDate(checkRequestDto.getDate());
    check.setPayeeId(checkRequestDto.getPayeeId());
    check.setAmount(checkRequestDto.getAmount());
    check.setPayerId(checkRequestDto.getPayerId());
    check = checkRepository.save(check);
    return checkDtoMapper.toDto(check);
  }

  @Override
  public CheckDto deleteCheck(String checkId) {
    Check check = checkRepository.findById(checkId)
        .orElseThrow(() -> new EntityNotFoundException("Check with id " + checkId + " not found"));
    checkRepository.delete(check);
    return checkDtoMapper.toDto(check);
  }

}
