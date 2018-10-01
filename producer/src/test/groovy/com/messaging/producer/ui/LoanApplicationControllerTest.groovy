package com.messaging.producer.ui

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class LoanApplicationControllerTest extends Specification {

    @Autowired
    LoanApplicationController loanApplicationController

    def 'should be able to get card when born in 80s or later'() {
        when:
            ResponseEntity response = loanApplicationController.applyForLoan(new LoanApplication("85101406621"))
        then:
            response.statusCode.is2xxSuccessful()
    }

    def 'should not be able to get card when born in 80s or later'() {
        when:
            ResponseEntity response = loanApplicationController.applyForLoan(new LoanApplication("50101599868"))
        then:
            response.statusCode.is4xxClientError()
    }
}
