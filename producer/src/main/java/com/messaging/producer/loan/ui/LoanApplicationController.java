package com.messaging.producer.loan.ui;

import com.messaging.producer.loan.application.ApplyForLoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController("/app")
public class LoanApplicationController {

    private final ApplyForLoanService applyForLoanService;

    public LoanApplicationController(ApplyForLoanService applyForLoanService) {
        this.applyForLoanService = applyForLoanService;
    }

    @PostMapping
    public ResponseEntity applyForLoan(@RequestBody LoanApplication loanApplication) {
        return applyForLoanService
                .apply(loanApplication.getPesel())
                .map(loan -> ok().build())
                .orElse(status(FORBIDDEN).build());
    }
}