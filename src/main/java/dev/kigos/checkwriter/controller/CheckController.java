package dev.kigos.checkwriter.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.kigos.checkwriter.dto.CheckDto;
import dev.kigos.checkwriter.dto.request.CreateCheckDto;
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
  public ResponseEntity<ApiResponse<CheckDto>> createCheck(@Valid @RequestBody CreateCheckDto checkCreateDto) {
    CheckDto check = checkService.createCheck(checkCreateDto);
    ApiResponse<CheckDto> reponse = new ApiResponse<>("Check created successfully", check);
    return ResponseEntity.ok(reponse);
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
    ApiResponse<Page<CheckDto>> response = new ApiResponse<>(checkService.findAll(pageable));
    return ResponseEntity.ok().body(response);
  }

}