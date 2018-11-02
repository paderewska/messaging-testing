package com.messaging.producer.loan.model;

import java.time.Instant;

public class LoanApplicationRejected implements DomainEvent {

    final String pesel;
    final Instant timestamp = Instant.now();

    public LoanApplicationRejected(String pesel) {
        this.pesel = pesel;
    }

    public String getPesel() {
        return pesel;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String getType() {
        return "loan-application-rejected";
    }
}
