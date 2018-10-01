package com.messaging.producer.loan.ui;

import com.messaging.producer.loan.DomainEventPublisher;
import com.messaging.producer.loan.model.LoanApplicationRejected;
import com.messaging.producer.loan.model.LoanGranted;
import com.messaging.producer.loan.ui.LoanApplication;
import com.messaging.producer.loan.ui.LoanApplicationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.isA;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyForLoanWithEventMockBeanTest {

    @Autowired
    LoanApplicationController loanApplicationController;

    @MockBean
    DomainEventPublisher domainEventPublisher;

    @Test
    public void shouldEmitLoanGrantedEvent() {

        //When
        loanApplicationController.applyForLoan(new LoanApplication("85101406622"));

        //Then
        Mockito.verify(domainEventPublisher).publish(isA(LoanGranted.class));
    }

    @Test
    public void shouldEmitLoanApplicationRejectedEvent() {

        //When
        loanApplicationController.applyForLoan(new LoanApplication("52101406622"));

        //Then
        Mockito.verify(domainEventPublisher).publish(isA(LoanApplicationRejected.class));

    }
}
