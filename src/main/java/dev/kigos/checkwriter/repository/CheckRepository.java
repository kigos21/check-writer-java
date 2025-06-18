package dev.kigos.checkwriter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.kigos.checkwriter.model.Check;

@Repository
public interface CheckRepository extends JpaRepository<Check, String> {

  @Query("SELECT c FROM Check c LEFT JOIN FETCH c.payer LEFT JOIN FETCH c.payee")
  Page<Check> findAllWithPayerAndPayee(Pageable pageable);

  @Query("SELECT c FROM Check c LEFT JOIN FETCH c.payer")
  Page<Check> findAllWithPayer(Pageable pageable);

  @Query("SELECT c FROM Check c LEFT JOIN FETCH c.payee p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :payeeName, '%'))")
  Page<Check> findAllWithPayee(@Param("payeeName") String payeeName, Pageable pageable);

}
