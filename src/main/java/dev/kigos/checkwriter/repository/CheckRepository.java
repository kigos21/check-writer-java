package dev.kigos.checkwriter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.kigos.checkwriter.model.Check;

@Repository
public interface CheckRepository extends JpaRepository<Check, String> {

}
