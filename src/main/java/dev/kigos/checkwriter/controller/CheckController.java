package dev.kigos.checkwriter.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CheckRequestDto;
import dev.kigos.checkwriter.dto.response.ApiResponse;
import dev.kigos.checkwriter.service.CheckService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/checks")
public class CheckController {

  private final CheckService checkService;

  public CheckController(CheckService checkService) {
    this.checkService = checkService;
  }

  @PostMapping("")
  public ResponseEntity<ApiResponse<CheckDto>> createCheck(@Valid @RequestBody CheckRequestDto checkCreateDto) {
    CheckDto check = checkService.createCheck(checkCreateDto);
    ApiResponse<CheckDto> response = new ApiResponse<>(check);
    return ResponseEntity.ok(response);
  }

  @GetMapping("")
  public ResponseEntity<ApiResponse<Page<CheckDto>>> getAllChecks(
      @RequestParam(defaultValue = "") String query,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "25") int size,
      @RequestParam(defaultValue = "updatedAt") String sortBy,
      @RequestParam(name = "asc", defaultValue = "false") boolean ascending) {

    Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);
    Page<CheckDto> checks = checkService.getChecks(query, pageable);
    ApiResponse<Page<CheckDto>> response = new ApiResponse<>(checks);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{checkId}")
  public ResponseEntity<ApiResponse<CheckDto>> getCheckById(@PathVariable String checkId) {
    CheckDto check = checkService.getCheckById(checkId);
    ApiResponse<CheckDto> response = new ApiResponse<>(check);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{checkId}")
  public ResponseEntity<ApiResponse<CheckDto>> getCheckById(@PathVariable String checkId,
      @Valid @RequestBody CheckRequestDto checkRequestDto) {

    CheckDto check = checkService.updateCheck(checkId, checkRequestDto);
    ApiResponse<CheckDto> response = new ApiResponse<>(check);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{checkId}")
  public ResponseEntity<ApiResponse<CheckDto>> deleteCheckById(@PathVariable String checkId) {
    CheckDto check = checkService.deleteCheck(checkId);
    ApiResponse<CheckDto> response = new ApiResponse<>(check);
    return ResponseEntity.ok(response);
  }

}