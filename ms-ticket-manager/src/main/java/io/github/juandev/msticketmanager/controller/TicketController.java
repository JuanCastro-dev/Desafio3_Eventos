package io.github.juandev.msticketmanager.controller;


import io.github.juandev.msticketmanager.model.Ticket;
import io.github.juandev.msticketmanager.service.TicketService;
import io.github.juandev.msticketmanager.web.dto.TicketDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("/get-ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable String id) {
        Ticket ticket = service.findById(id);
        return ResponseEntity.ok().body(ticket);
    }

    @PostMapping(value = "/create-ticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody @Validated TicketDto ticketDto) {
        Ticket ticket = service.save(ticketDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @PutMapping("/update-ticket/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String id, @RequestBody TicketDto ticketDto) {
        Ticket ticket = service.update(ticketDto, id);
        return ResponseEntity.ok().body(ticket);
    }

    @DeleteMapping("/cancel-ticket/{id}")
    public ResponseEntity cancelTicket(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/check-tickets-by-event/{eventId}")
    public ResponseEntity<List<Ticket>> checkTicketsByEvent(@PathVariable String eventId) {
        List<Ticket> tickets = service.findByEvent(eventId);
        return ResponseEntity.ok().body(tickets);
    }

}
