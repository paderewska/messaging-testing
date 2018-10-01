package com.messaging.producer.loan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Loan {

    @Id
    private UUID loanNo = UUID.randomUUID();
    private String pesel;
    private BigDecimal cardLimit;

    private Loan(String pesel, BigDecimal limit) {
        this.pesel = pesel;
        this.cardLimit = limit;
    }

    public Loan() {
    }

    public static Loan withDefaultLimit(String pesel) {
        return new Loan(pesel, new BigDecimal(2000));
    }

    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    public UUID getCardNo() {
        return loanNo;
    }
}
