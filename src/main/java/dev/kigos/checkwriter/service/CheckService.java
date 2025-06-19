package dev.kigos.checkwriter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CheckRequestDto;

public interface CheckService {

  CheckDto createCheck(CheckRequestDto checkRequestDto);

  Page<CheckDto> getChecks(String payeeName, Pageable pageable);

  CheckDto getCheckById(String checkId);

  CheckDto updateCheck(String checkId, CheckRequestDto checkRequestDto);

  CheckDto deleteCheck(String checkId);

}