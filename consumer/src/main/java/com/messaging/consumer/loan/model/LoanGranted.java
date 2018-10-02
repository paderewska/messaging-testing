package com.messaging.consumer.loan.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class LoanGranted {

    UUID loanNo;
    BigDecimal loanLimit;
    String pesel;
    Instant timestamp;

    public LoanGranted(UUID loanNo, BigDecimal loanLimit, String pesel) {
        this.loanNo = loanNo;
        this.loanLimit = loanLimit;
        this.pesel = pesel;
        this.timestamp = Instant.now();
    }

    public LoanGranted() {
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

}
