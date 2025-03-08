package io.github.juandev.mseventmanager.controller;

import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.service.EventService;
import io.github.juandev.mseventmanager.web.dto.EventDto;
import io.github.juandev.mseventmanager.web.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventService service;
    private final EventMapper mapper;

    @Autowired
    public EventController(EventService service, EventMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/get-event/{id}")
    public ResponseEntity<Event> findById(@RequestParam String id) {
        Event event = service.findById(id);
        return ResponseEntity.ok().body(event);
    }

    @GetMapping("/get-all-events")
    public ResponseEntity<List<Event>> findAll() {
        List<Event> events = service.findAll();
        return ResponseEntity.ok().body(events);
    }

    @PostMapping(value = "/create-event")
    public ResponseEntity<Event> createEvent(@RequestBody EventDto eventDto) {
        Event event = service.save(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @PutMapping(value = "/update-event/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody EventDto eventDto, @RequestParam String id) {
        Event event = service.update(mapper.DtoToEvent(eventDto),id);
        return ResponseEntity.ok().body(event);
    }

    @DeleteMapping(value = "/delete-event/{id}")
    public ResponseEntity<Event> deleteEvent(@RequestParam String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
