package io.github.juandev.mseventmanager.repository;

import io.github.juandev.mseventmanager.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
