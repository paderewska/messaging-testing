package com.messaging.producer.application;

import com.messaging.producer.DomainEventPublisher;
import com.messaging.producer.model.Loan;
import com.messaging.producer.model.LoanApplicationRejected;
import com.messaging.producer.model.LoanGranted;
import com.messaging.producer.model.LoanRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.lang.Integer.valueOf;
import static java.util.Optional.of;

@Service
public class ApplyForLoanService {

    private final DomainEventPublisher domainEventPublisher;
    private final LoanRepository loanRepository;

    public ApplyForLoanService(DomainEventPublisher domainEventPublisher, LoanRepository loanRepository) {
        this.domainEventPublisher = domainEventPublisher;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public Optional<Loan> apply(String pesel) {
        if (bornBeforeSixties(pesel)) {
            domainEventPublisher.publish(new LoanApplicationRejected(pesel));
            return Optional.empty();
        }
        Loan loan = Loan.withDefaultLimit(pesel);
        loanRepository.save(loan);
        domainEventPublisher.publish((new LoanGranted(loan.getCardNo(), loan.getCardLimit(), pesel)));
        return of(loan);
    }

    private boolean bornBeforeSixties(String pesel) {
        return valueOf(pesel.substring(0, 2)) < 70;
    }

}
