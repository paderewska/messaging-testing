package com.messaging.producer;

import com.messaging.producer.model.DomainEvent;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

public class ToRabbitMqEventPublisher implements DomainEventPublisher {

    private final Source source;

    public ToRabbitMqEventPublisher(Source source) {
        this.source = source;
    }

    @Override
    public void publish(DomainEvent event) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("type", event.getType());
        source.output().send(new GenericMessage<>(event, headers));
    }
}
