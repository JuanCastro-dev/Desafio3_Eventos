package io.github.juandev.msticketmanager.repository;

import io.github.juandev.msticketmanager.model.Event;
import io.github.juandev.msticketmanager.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findByEvent(Event event);
}
