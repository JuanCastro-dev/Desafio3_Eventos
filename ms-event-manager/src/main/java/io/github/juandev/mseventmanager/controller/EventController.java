package io.github.juandev.mseventmanager.controller;

import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventService service;

    @Autowired
    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> findById(@RequestParam String id) {
        Event event = service.findById(id);
        return ResponseEntity.ok().body(event);
    }

    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        List<Event> events = service.findAll();
        return ResponseEntity.ok().body(events);
    }
}
