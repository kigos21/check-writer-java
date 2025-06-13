package dev.kigos.checkwriter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.kigos.checkwriter.model.Payer;

@Repository
public interface PayerRepository extends JpaRepository<Payer, String> {

}
