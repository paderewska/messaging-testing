package com.messaging.producer.loan.ui;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanApplication {

    private final String pesel;

    @JsonCreator
    LoanApplication(@JsonProperty("pesel") String pesel) {
        this.pesel = pesel;
    }

    public String getPesel() {
        return pesel;
    }
}
