package com.messaging.producer.loan.events

import com.messaging.producer.loan.DomainEventPublisher
import com.messaging.producer.loan.application.ApplyForLoanService
import com.messaging.producer.loan.model.LoanApplicationRejected
import com.messaging.producer.loan.model.LoanGranted
import com.messaging.producer.loan.model.LoanRepository
import spock.lang.Specification

class ApplyForLoanWithEventUnitTest extends Specification {

    LoanRepository loanRepository = Stub()
    DomainEventPublisher publisher = Mock()
    ApplyForLoanService applyForLoanService = new ApplyForLoanService(publisher, loanRepository)

    def 'should emit LoanGranted when client born in 60s or later'() {
        when:
        applyForLoanService.apply("85101406621")
        then:
        1 * publisher.publish({it as LoanGranted})
    }

    def 'should emit LoanApplicationRejected when client born in 60s or later'() {
        when:
        applyForLoanService.apply("52101406621")
        then:
        1 * publisher.publish({it as LoanApplicationRejected})
    }
}