package com.messaging.producer.application;

import com.messaging.producer.model.Loan;
import com.messaging.producer.model.LoanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.lang.Integer.valueOf;

@Service
public class ApplyForLoanService {

    private final LoanRepository loanRepository;

    public ApplyForLoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Transactional
    public Optional<Loan> apply(String pesel) {

        return Optional.empty();
    }

    private boolean bornBeforeSixties(String pesel) {
        return valueOf(pesel.substring(0, 2)) < 70;
    }

}
