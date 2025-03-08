package io.github.juandev.mseventmanager.service;

import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.repository.EventRepository;
import io.github.juandev.mseventmanager.web.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    @Autowired
    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event save(Event event) {
        return repository.save(event);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Event update(EventDto event, String id) {
        Event oldEvent = findById(id);
        oldEvent.setEventName(event.getEventName());
        oldEvent.setDateTime(event.getDateTime());
        oldEvent.setCep(event.getCep());
        //Faltando as operações para alterar os demais atributos do endereço
        return repository.save(oldEvent);
    }
}
