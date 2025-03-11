package io.github.juandev.mseventmanager.client;

import io.github.juandev.mseventmanager.model.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//configurar para o endereço publico depois
@Component
@FeignClient(name = "ms-ticket-manager", url = "http://localhost:8080")
public interface TicketClient {

    @GetMapping(value = "/tickets/check-tickets-by-event/{id}")
    List<Ticket> checkTicketsByEvent(@PathVariable String id);
}
