package dev.kigos.checkwriter.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import dev.kigos.checkwriter.util.NanoIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  protected String id;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  protected Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  protected Instant updatedAt;

  @PrePersist
  protected void onCreate() {
    if (this.id == null) {
      this.id = NanoIdGenerator.generate();
    }
  }

}