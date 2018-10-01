package com.messaging.producer;

import com.messaging.producer.model.DomainEvent;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
