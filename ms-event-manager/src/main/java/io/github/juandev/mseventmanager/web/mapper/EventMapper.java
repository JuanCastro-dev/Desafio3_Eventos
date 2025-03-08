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

    public static EventDto EventToDto(Event event) {
        return new ModelMapper().map(event, EventDto.class);
    }

    public static Event DtoToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setEventName(eventDto.getEventName());
        event.setCep(eventDto.getCep());
        event.setDateTime(eventDto.getDateTime());
        return event;
    }
}
