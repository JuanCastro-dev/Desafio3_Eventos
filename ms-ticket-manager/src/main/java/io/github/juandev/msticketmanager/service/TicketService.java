package io.github.juandev.msticketmanager.service;

import io.github.juandev.msticketmanager.client.EventClient;
import io.github.juandev.msticketmanager.model.Event;
import io.github.juandev.msticketmanager.model.Ticket;
import io.github.juandev.msticketmanager.repository.TicketRepository;
import io.github.juandev.msticketmanager.web.dto.TicketDto;
import io.github.juandev.msticketmanager.web.dto.mapper.TicketMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final EventClient eventClient;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper, EventClient eventClient) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.eventClient = eventClient;
    }

    public Ticket findById(String ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(
                () -> new RuntimeException("Ticket not found")
        );
    }

    //validar se o evento existe
    public Ticket save(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.DtoToTicket(ticketDto);

        Event event = eventClient.findById(ticketDto.getEventId());
        ticket.setEvent(event);

        return ticketRepository.save(ticket);
    }

    public void deleteById(String ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public Ticket update(TicketDto ticketDto, String ticketId) {
        Ticket ticket = findById(ticketId);
        ticket.setCpf(ticketDto.getCpf());
        ticket.setCustomerName(ticketDto.getCustomerName());
        ticket.setCustomerMail(ticketDto.getCustomerMail());
        ticket.setBrlTotalAmount(ticketDto.getBrlTotalAmount());
        ticket.setUsdTotalAmount(ticketDto.getUsdTotalAmount());

        Event event = eventClient.findById(ticketDto.getEventId());
        ticket.setEvent(event);

        return ticketRepository.save(ticket);
    }

    public List<Ticket> findByEvent(String eventId) {
        Event event = eventClient.findById(eventId);
        return ticketRepository.findByEvent(event);
    }
}
