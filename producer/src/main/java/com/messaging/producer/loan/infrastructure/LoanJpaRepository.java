package com.messaging.producer.loan.infrastructure;

import com.messaging.producer.loan.model.Loan;
import com.messaging.producer.loan.model.LoanRepository;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;
import java.util.UUID;

public interface LoanJpaRepository extends CrudRepository<Loan, UUID>, LoanRepository {
}
