package com.messaging.producer.ui

import com.messaging.producer.DomainEventPublisher
import com.messaging.producer.model.LoanGranted
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

@SpringBootTest
class ApplyForLoanWithEventMockBeanTest extends Specification {

    @Autowired
    LoanApplicationController loanApplicationController

    @MockBean
    DomainEventPublisher domainEventPublisher;

    def 'should emit LoanGranted event'(){

    }

    def 'should emit LoanApplicationRejected event'(){

    }

}
