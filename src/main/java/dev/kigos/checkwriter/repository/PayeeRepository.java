package dev.kigos.checkwriter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.kigos.checkwriter.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, String> {

}
