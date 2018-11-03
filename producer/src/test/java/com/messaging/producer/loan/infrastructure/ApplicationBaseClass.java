package com.messaging.producer.loan.infrastructure;

import com.messaging.producer.loan.model.LoanApplicationRejected;
import com.messaging.producer.loan.model.LoanGranted;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollectorAutoConfiguration;
import org.springframework.cloud.stream.test.binder.TestSupportBinderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBaseClass.Config.class)
@AutoConfigureMessageVerifier
public class ApplicationBaseClass {

    private static final String VALID_PERSONAL_ID = "86010197600";
    private static final String INVALID_PERSONAL_ID = "86010156812";

    @Autowired
    RabbitMqEventPublisher publisher;

    public void sendAccepted() {
        publisher.publish(new LoanGranted(UUID.randomUUID(), BigDecimal.ONE, VALID_PERSONAL_ID));
    }

    public void sendRejected() {
        publisher.publish(new LoanApplicationRejected(INVALID_PERSONAL_ID));
    }

    @Configuration
    @ImportAutoConfiguration({TestSupportBinderAutoConfiguration.class,
            MessageCollectorAutoConfiguration.class, JacksonAutoConfiguration.class})
    @EnableBinding(Source.class)
    static class Config {
        @Bean
        RabbitMqEventPublisher publisher(Source source){
            return new RabbitMqEventPublisher(source);
        }
    }
}
