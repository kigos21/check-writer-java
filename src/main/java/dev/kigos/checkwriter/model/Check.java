package dev.kigos.checkwriter.model;

import java.math.BigDecimal;
import java.time.Instant;

import dev.kigos.checkwriter.util.NanoIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "checks")
@EqualsAndHashCode(callSuper = false)
public class Check extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payer_id", nullable = false)
  private Payer payer;

  @Column(name = "date", nullable = false)
  private Instant date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payee_id", nullable = false)
  private Payee payee;

  @Column(name = "amount", precision = 12, scale = 2)
  private BigDecimal amount;

  @PrePersist
  protected void onCreate() {
    if (this.id == null) {
      this.id = NanoIdGenerator.generateWithPrefix("chk");
    }
  }

}
