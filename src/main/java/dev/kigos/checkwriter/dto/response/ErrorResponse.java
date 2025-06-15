package dev.kigos.checkwriter.dto.response;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponse {
  private String message;
  private Map<String, List<String>> errors;
  private Instant timestamp;

  public ErrorResponse(String message) {
    this.message = message;
    this.timestamp = Instant.now();
  }

  public ErrorResponse(String message, Map<String, List<String>> errors) {
    this.message = message;
    this.errors = errors;
    this.timestamp = Instant.now();
  }
}
