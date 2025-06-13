package dev.kigos.checkwriter.model;

import java.math.BigDecimal;
import java.time.Instant;

import dev.kigos.checkwriter.util.NanoIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "checks")
@EqualsAndHashCode(callSuper = false)
public class Check extends BaseEntity {

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
    if (this.id == null) {
      this.id = NanoIdGenerator.generateWithPrefix("chk");
    }
  }

}
