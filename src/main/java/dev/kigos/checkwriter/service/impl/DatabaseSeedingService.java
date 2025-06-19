package dev.kigos.checkwriter.service.impl;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.kigos.checkwriter.model.Check;
import dev.kigos.checkwriter.model.Payee;
import dev.kigos.checkwriter.model.Payer;
import dev.kigos.checkwriter.repository.CheckRepository;
import dev.kigos.checkwriter.repository.PayeeRepository;
import dev.kigos.checkwriter.repository.PayerRepository;
import dev.kigos.checkwriter.service.CheckService;
import dev.kigos.checkwriter.service.PayeeService;
import dev.kigos.checkwriter.service.PayerService;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Slf4j
@Service
public class DatabaseSeedingService implements CommandLineRunner {

  private final PayerRepository payerRepository;
  private final PayeeRepository payeeRepository;
  private final CheckRepository checkRepository;
  private final Faker faker = new Faker();

  public DatabaseSeedingService(PayerService payerService, PayerRepository payerRepository, PayeeService payeeService,
      PayeeRepository payeeRepository, CheckService checkService, CheckRepository checkRepository,
      ObjectMapper objectMapper) {
    this.payerRepository = payerRepository;
    this.payeeRepository = payeeRepository;
    this.checkRepository = checkRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (payerRepository.count() == 0) {
      log.info("Seeding realistic fake data...");

      List<Payer> payers = seedPayers();
      List<Payee> payees = seedPayees();
      seedChecks(payers, payees);

      log.info("Seeded {} payers, {} payees, {} checks",
          payers.size(), payees.size(), checkRepository.count());
    }
  }

  private List<Payer> seedPayers() {
    return IntStream.range(0, 5).mapToObj(i -> {
      Payer payer = new Payer();
      payer.setName(faker.company().name());
      payer.setNotes(faker.company().catchPhrase());
      return payerRepository.save(payer);
    }).toList();
  }

  private List<Payee> seedPayees() {
    return IntStream.range(0, 30).mapToObj(i -> {
      Payee payee = new Payee();
      payee.setName(faker.name().name());
      return payeeRepository.save(payee);
    }).toList();
  }

  private void seedChecks(List<Payer> payers, List<Payee> payees) {
    IntStream.range(0, 100).forEach(i -> {
      Check check = new Check();

      // Random payer and payee
      String payerId = payers.get(faker.random().nextInt(payers.size())).getId();
      String payeeId = payees.get(faker.random().nextInt(payees.size())).getId();
      check.setPayerId(payerId);
      check.setPayeeId(payeeId);

      // Php 1000 - 1.5m
      BigDecimal amount = BigDecimal.valueOf(faker.number().randomDouble(2, 1000, 1500000));
      check.setAmount(amount);

      // Random date within the last 6 months
      Instant randomDate = Instant.now().minus(
          faker.number().numberBetween(1, 180),
          ChronoUnit.DAYS);
      check.setDate(randomDate);

      // Save
      checkRepository.save(check);
    });
  }

}
