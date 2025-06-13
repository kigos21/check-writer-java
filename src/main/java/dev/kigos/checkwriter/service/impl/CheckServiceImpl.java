package dev.kigos.checkwriter.service.impl;

import org.springframework.stereotype.Service;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.mapper.CheckDtoMapper;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;
import dev.kigos.checkwriter.model.Check;
import dev.kigos.checkwriter.repository.CheckRepository;
import dev.kigos.checkwriter.service.CheckService;

@Service
public class CheckServiceImpl implements CheckService {

  private final CheckDtoMapper checkDtoMapper;
  private final CheckRepository checkRepository;

  public CheckServiceImpl(CheckDtoMapper checkDtoMapper, CheckRepository checkRepository) {
    this.checkDtoMapper = checkDtoMapper;
    this.checkRepository = checkRepository;
  }

  @Override
  public CheckDto createCheck(CreateCheckDto createCheckDto) {
    Check newCheck = checkDtoMapper.toEntity(createCheckDto);
    return checkDtoMapper.toDto(checkRepository.save(newCheck));
  }

}
