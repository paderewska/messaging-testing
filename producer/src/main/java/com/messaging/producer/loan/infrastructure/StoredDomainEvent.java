package com.messaging.producer.loan.infrastructure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class StoredDomainEvent {

    @Id
    @GeneratedValue
    Long id;
    private String content;
    private boolean sent;
    private Instant timestamp = Instant.now();

    StoredDomainEvent(String content) {
        this.content = content;
    }

    private StoredDomainEvent() {
    }

    void sent() {
        sent = true;
    }

    String getContent() {
        return content;
    }
}
