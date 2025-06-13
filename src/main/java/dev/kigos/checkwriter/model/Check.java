package dev.kigos.checkwriter.model;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import dev.kigos.checkwriter.util.NanoIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "checks")
public class Check {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private String id;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @Column(name = "payer_id", nullable = false)
  private String payerId;

  @Column(name = "date", nullable = false)
  private Instant date;

  @Column(name = "payee_id", nullable = false)
  private String payeeId;

  @Column(name = "amount", precision = 12, scale = 2)
  private BigDecimal amount;

  @PrePersist
  protected void onCreate() {
    this.id = NanoIdGenerator.generateWithPrefix("chk");
  }

}
