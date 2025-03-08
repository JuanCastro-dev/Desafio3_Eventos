package io.github.juandev.mseventmanager.web.mapper;

import io.github.juandev.mseventmanager.client.ViacepClient;
import io.github.juandev.mseventmanager.model.Address;
import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.web.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    private final ViacepClient viacepClient;

    //Eai juan ?
    @Autowired
    public EventMapper(ViacepClient viacepClient) {
        this.viacepClient = viacepClient;
    }


    public static EventDto EventToDto(Event event) {
        return new ModelMapper().map(event, EventDto.class);
    }

    public static Event DtoToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setEventName(eventDto.getEventName());
        event.setCep(eventDto.getCep());
        event.setDateTime(eventDto.getDateTime());
        Address address = viacepClient.getAddressByCep(eventDto.getCep());
        event.setLocalidade(address.getLocalidade());
        event.setUf(address.getUf());
        event.setBairro(address.getBairro());
        event.setLogradouro(address.getLogradouro());
        return event;
    }
}
