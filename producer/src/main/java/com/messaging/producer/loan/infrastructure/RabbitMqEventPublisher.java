package com.messaging.producer.loan.infrastructure;

import com.messaging.producer.loan.DomainEventPublisher;
import com.messaging.producer.loan.model.DomainEvent;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RabbitMqEventPublisher implements DomainEventPublisher {

    private final Source source;

    public RabbitMqEventPublisher(Source source) {
        this.source = source;
    }

    @Override
    public void publish(DomainEvent event) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("type", event.getType());
        source.output().send(new GenericMessage<>(event, headers));
    }
}
