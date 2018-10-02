package com.messaging.consumer.loan;

import com.messaging.consumer.loan.model.LoanApplicationRejected;
import com.messaging.consumer.loan.model.LoanGranted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'loan-granted'")
    public void receiveGranted(@Payload LoanGranted granted) {
        log.info("\n\nGRANTED [" + granted.getPesel() + "] !!!! :) :) :)\n\n");
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'loan-application-rejected'")
    public void receiveRejected(@Payload LoanApplicationRejected rejected) {
        log.info("\n\nREJECTED [" + rejected.getPesel() + "] !!!! :| :( ;(\n\n");
    }
}
