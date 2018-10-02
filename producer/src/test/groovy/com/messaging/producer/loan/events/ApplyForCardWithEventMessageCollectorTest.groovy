package com.messaging.producer.loan.events

import com.messaging.producer.loan.ui.LoanApplication
import com.messaging.producer.loan.ui.LoanApplicationController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.GenericMessage
import spock.lang.Specification

import java.util.concurrent.BlockingQueue

@SpringBootTest
class ApplyForCardWithEventMessageCollectorTest extends Specification {

    @Autowired
    LoanApplicationController loanApplicationController

    @Autowired
    Source source

    @Autowired
    MessageCollector messageCollector

    BlockingQueue<GenericMessage<String>> events

    def setup() {
        events = messageCollector.forChannel(source.output())
    }

    def 'should be able to get loan when born in 60s or later'() {
        when:
            loanApplicationController.applyForLoan(new LoanApplication("86101406622"))
        then:
            events.poll().headers.containsValue("loan-granted")
    }

    def 'should not be able to get card when born before 60s'() {
        when:
        loanApplicationController.applyForLoan(new LoanApplication("56101406622"))
        then:
        events.poll().headers.containsValue("card-application-rejected")
    }
}
