package dev.kigos.checkwriter.dto.response;

import java.time.Instant;

import lombok.Data;

@Data
public class ApiResponse<T> {
  private String message;
  private T data;
  private Instant timestamp;

  public ApiResponse(String message) {
    this.message = message;
  }

  public ApiResponse(T data) {
    this.data = data;
  }

  public ApiResponse(String message, T data) {
    this.message = message;
    this.data = data;
  }
}