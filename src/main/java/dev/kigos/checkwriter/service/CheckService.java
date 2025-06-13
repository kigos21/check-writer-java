package dev.kigos.checkwriter.service;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;

public interface CheckService {
  CheckDto createCheck(CreateCheckDto checkCreateDto);
}