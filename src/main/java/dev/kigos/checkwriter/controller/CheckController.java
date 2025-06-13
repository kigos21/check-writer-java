package dev.kigos.checkwriter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;
import dev.kigos.checkwriter.service.CheckService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/checks")
public class CheckController {

  private final CheckService checkService;

  public CheckController(CheckService checkService) {
    this.checkService = checkService;
  }

  @PostMapping
  public ResponseEntity<CheckDto> postMethodName(@Valid @RequestBody CreateCheckDto checkCreateDto) {
    return ResponseEntity.ok(checkService.createCheck(checkCreateDto));
  }

}