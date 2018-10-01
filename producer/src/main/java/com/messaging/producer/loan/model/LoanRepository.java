package com.messaging.producer.loan.model;

import org.springframework.data.repository.CrudRepository;;

import java.util.Optional;
import java.util.UUID;

public interface LoanRepository extends CrudRepository<Loan, UUID> {

    Loan save(Loan loan);

    Optional<Loan> findById(UUID uuid);
}
