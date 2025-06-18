package dev.kigos.checkwriter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;

public interface CheckService {
  CheckDto createCheck(CreateCheckDto checkCreateDto);

  Page<CheckDto> findAll(String payeeName, Pageable pageable);
}