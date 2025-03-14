package io.github.juandev.mseventmanager.service;

import feign.FeignException;
import io.github.juandev.mseventmanager.client.TicketClient;
import io.github.juandev.mseventmanager.client.ViacepClient;
import io.github.juandev.mseventmanager.exception.BadRequestException;
import io.github.juandev.mseventmanager.exception.HasTicketsSoldOutException;
import io.github.juandev.mseventmanager.exception.NotFoundException;
import io.github.juandev.mseventmanager.model.Address;
import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.repository.EventRepository;
import io.github.juandev.mseventmanager.web.dto.EventDto;
import io.github.juandev.mseventmanager.web.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;
    private final ViacepClient viacepClient;
    private final TicketClient ticketClient;

    @Autowired
    public EventService(EventRepository repository, EventMapper mapper, ViacepClient viacepClient, TicketClient ticketClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.viacepClient = viacepClient;
        this.ticketClient = ticketClient;
    }

    public Event findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Event with id: "+id+" not found")
        );
    }

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event save(EventDto eventDto) {
        try {
            Event event = mapper.DtoToEvent(eventDto);

            String cep = event.getCep().replace("-", "");

            Address address = viacepClient.getAddressByCep(cep);
            event.setLogradouro(address.getLogradouro());
            event.setLocalidade(address.getLocalidade());
            event.setUf(address.getUf());
            event.setBairro(address.getBairro());

            return repository.save(event);
        }catch (FeignException.FeignClientException e){
            throw new BadRequestException("Invalid CEP");
        }
    }

    public void deleteById(String id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Event with id: "+id+" not found");
        }
        if (!ticketClient.checkTicketsByEvent(id).isEmpty()){
            throw new HasTicketsSoldOutException("Tickets are sold, event cannot be deleted");
        }
        repository.deleteById(id);
    }

    public Event update(Event event, String id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Event with id: "+id+" not found");
        }
        try {
            Event oldEvent = findById(id);
            oldEvent.setEventName(event.getEventName());
            oldEvent.setDateTime(event.getDateTime());
            oldEvent.setCep(event.getCep());

            String cep = event.getCep().replace("-", "");

            Address newAddress = viacepClient.getAddressByCep(cep);
            oldEvent.setLogradouro(newAddress.getLogradouro());
            oldEvent.setLocalidade(newAddress.getLocalidade());
            oldEvent.setUf(newAddress.getUf());
            oldEvent.setBairro(newAddress.getBairro());

            return repository.save(oldEvent);
        }catch (FeignException.FeignClientException e){
            throw new BadRequestException("Invalid CEP");
        }
    }
}
