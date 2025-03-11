package io.github.juandev.msticketmanager.service;

import feign.FeignException;
import io.github.juandev.msticketmanager.client.EventClient;
import io.github.juandev.msticketmanager.exception.BadRequestException;
import io.github.juandev.msticketmanager.exception.NotFoundException;
import io.github.juandev.msticketmanager.model.Event;
import io.github.juandev.msticketmanager.model.Ticket;
import io.github.juandev.msticketmanager.repository.TicketRepository;
import io.github.juandev.msticketmanager.web.dto.TicketDto;
import io.github.juandev.msticketmanager.web.dto.mapper.TicketMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
                () -> new NotFoundException("Ticket not found")
        );
    }

    //validar se o evento existe
    public Ticket save(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.DtoToTicket(ticketDto);

        try{
            Event event = eventClient.findById(ticketDto.getEventId());
            ticket.setEvent(event);
            return ticketRepository.save(ticket);
        }
        catch (FeignException.FeignClientException e){
            throw new NotFoundException("Event not found");
        }
        //Depois ver a excessão dos bad requests que não está indo
    }

    public void deleteById(String ticketId) {
        if (!ticketRepository.existsById(ticketId)) {
            throw new NotFoundException("Ticket not found");
        }
        ticketRepository.deleteById(ticketId);
    }

    public Ticket update(TicketDto ticketDto, String ticketId) {
        if (!ticketRepository.existsById(ticketId)) {
            throw new NotFoundException("Ticket not found");
        }

        Ticket ticket = findById(ticketId);
        ticket.setCpf(ticketDto.getCpf());
        ticket.setCustomerName(ticketDto.getCustomerName());
        ticket.setCustomerMail(ticketDto.getCustomerMail());
        ticket.setBrlTotalAmount(ticketDto.getBrlTotalAmount());
        ticket.setUsdTotalAmount(ticketDto.getUsdTotalAmount());

        Event event = eventClient.findById(ticketDto.getEventId());
        ticket.setEvent(event);

        return ticketRepository.save(ticket);

        //Depois ver a excessão dos bad requests que não está indo
    }

    public List<Ticket> findByEvent(String eventId) {
        try {
            Event event = eventClient.findById(eventId);
            return ticketRepository.findByEvent(event);
        }catch (FeignException.FeignClientException e){
            throw new NotFoundException("Event not found");
        }
    }
}
