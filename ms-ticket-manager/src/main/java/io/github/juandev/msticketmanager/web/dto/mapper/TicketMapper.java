package io.github.juandev.msticketmanager.web.dto.mapper;

import io.github.juandev.msticketmanager.model.Ticket;
import io.github.juandev.msticketmanager.web.dto.TicketDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public static TicketDto TicketToDto(Ticket ticket) {
        return new ModelMapper().map(ticket, TicketDto.class);
    }

    public static Ticket DtoToTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setCpf(ticketDto.getCpf());
        ticket.setCustomerName(ticketDto.getCustomerName());
        ticket.setCustomerMail(ticketDto.getCustomerMail());
        ticket.setBrlTotalAmount(ticketDto.getBrlTotalAmount());
        ticket.setUsdTotalAmount(ticketDto.getUsdTotalAmount());
        return ticket;
    }
}
