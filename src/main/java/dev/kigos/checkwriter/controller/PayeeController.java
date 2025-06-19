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

import dev.kigos.checkwriter.dto.PayeeDto;
import dev.kigos.checkwriter.dto.request.PayeeRequestDto;
import dev.kigos.checkwriter.dto.response.ApiResponse;
import dev.kigos.checkwriter.service.PayeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/payees")
public class PayeeController {

  private final PayeeService payeeService;

  public PayeeController(PayeeService payeeService) {
    this.payeeService = payeeService;
  }

  @PostMapping("")
  public ResponseEntity<ApiResponse<PayeeDto>> createPayee(@Valid @RequestBody PayeeRequestDto payeeRequestDto) {
    PayeeDto payee = payeeService.createPayee(payeeRequestDto);
    ApiResponse<PayeeDto> response = new ApiResponse<>(payee);
    return ResponseEntity.ok(response);
  }

  @GetMapping("")
  public ResponseEntity<ApiResponse<Page<PayeeDto>>> getAllPayees(
      @RequestParam(defaultValue = "") String query,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "25") int size,
      @RequestParam(defaultValue = "updatedAt") String sortBy,
      @RequestParam(name = "asc", defaultValue = "false") boolean ascending) {

    Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);
    Page<PayeeDto> payees = payeeService.getPayees(query, pageable);
    ApiResponse<Page<PayeeDto>> response = new ApiResponse<>(payees);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{payeeId}")
  public ResponseEntity<ApiResponse<PayeeDto>> getPayeeById(@PathVariable String payeeId,
      @Valid @RequestBody PayeeRequestDto payeeRequestDto) {

    PayeeDto payee = payeeService.updatePayee(payeeId, payeeRequestDto);
    ApiResponse<PayeeDto> response = new ApiResponse<>(payee);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{payeeId}")
  public ResponseEntity<ApiResponse<PayeeDto>> deletePayeeById(@PathVariable String payeeId) {
    PayeeDto payee = payeeService.deletePayee(payeeId);
    ApiResponse<PayeeDto> response = new ApiResponse<>(payee);
    return ResponseEntity.ok(response);
  }

}
