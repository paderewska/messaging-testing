package com.messaging.producer.loan;

import com.messaging.producer.loan.model.DomainEvent;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
