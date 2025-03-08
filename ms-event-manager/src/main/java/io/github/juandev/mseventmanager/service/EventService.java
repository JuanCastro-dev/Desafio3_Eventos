package io.github.juandev.mseventmanager.service;

import io.github.juandev.mseventmanager.client.ViacepClient;
import io.github.juandev.mseventmanager.model.Address;
import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.repository.EventRepository;
import io.github.juandev.mseventmanager.web.dto.EventDto;
import io.github.juandev.mseventmanager.web.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;
    private final ViacepClient viacepClient;

    @Autowired
    public EventService(EventRepository repository, EventMapper mapper, ViacepClient viacepClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.viacepClient = viacepClient;
    }

    public Event findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event save(EventDto eventDto) {
        Event event = mapper.DtoToEvent(eventDto);

        Address address = viacepClient.getAddressByCep(event.getCep());
        event.setLogradouro(address.getLogradouro());
        event.setLocalidade(address.getLocalidade());
        event.setUf(address.getUf());
        event.setBairro(address.getBairro());

        return repository.save(event);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Event update(Event event, String id) {
        Event oldEvent = findById(id);
        oldEvent.setEventName(event.getEventName());
        oldEvent.setDateTime(event.getDateTime());
        oldEvent.setCep(event.getCep());

        Address newAddress = viacepClient.getAddressByCep(event.getCep());
        oldEvent.setLogradouro(newAddress.getLogradouro());
        oldEvent.setLocalidade(newAddress.getLocalidade());
        oldEvent.setUf(newAddress.getUf());
        oldEvent.setBairro(newAddress.getBairro());

        return repository.save(oldEvent);
    }
}
