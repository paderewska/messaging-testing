package com.messaging.producer.loan.infrastructure;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DomainEventStorage extends CrudRepository<StoredDomainEvent, Long> {

    List<StoredDomainEvent> findAllBySentOrderByTimestampDesc(boolean sent);
}
