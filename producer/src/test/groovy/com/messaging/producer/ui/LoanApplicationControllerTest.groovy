package com.messaging.producer.ui

import com.messaging.producer.DomainEventPublisher
import com.messaging.producer.application.ApplyForLoanService
import com.messaging.producer.model.LoanRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class LoanApplicationControllerTest extends Specification {

    LoanRepository loanRepository = Stub()
    DomainEventPublisher publisher = Mock()
    ApplyForLoanService applyForLoanService = new ApplyForLoanService(publisher, loanRepository)

    LoanApplicationController loanApplicationController = new LoanApplicationController(applyForLoanService)

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
