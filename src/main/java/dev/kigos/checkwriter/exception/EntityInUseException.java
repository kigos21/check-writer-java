package dev.kigos.checkwriter.exception;

public class EntityInUseException extends RuntimeException {
  public EntityInUseException(String message) {
    super(message);
  }
}
