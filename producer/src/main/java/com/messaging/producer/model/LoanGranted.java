package com.messaging.producer.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class LoanGranted implements DomainEvent {

    final UUID loanNo;
    final BigDecimal loanLimit;
    final String pesel;
    final Instant timestamp = Instant.now();

    public LoanGranted(UUID loanNo, BigDecimal loanLimit, String pesel) {
        this.loanNo = loanNo;
        this.loanLimit = loanLimit;
        this.pesel = pesel;
    }

    public UUID getLoanNo() {
        return loanNo;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public String getPesel() {
        return pesel;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String getType() {
        return "loan-granted";
    }
}
