package com.messaging.consumer.loan.model;

import java.time.Instant;

public class LoanApplicationRejected {

    String pesel;
    Instant timestamp;

    public LoanApplicationRejected(String pesel) {
        this.pesel = pesel;
        this.timestamp = Instant.now();
    }

    public LoanApplicationRejected() {
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPesel() {
        return pesel;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

}
