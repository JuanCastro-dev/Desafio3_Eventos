package io.github.juandev.msticketmanager;

import io.github.juandev.msticketmanager.model.Event;
import io.github.juandev.msticketmanager.model.Ticket;
import io.github.juandev.msticketmanager.repository.TicketRepository;
import io.github.juandev.msticketmanager.web.dto.mapper.TicketMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketIT {

    @LocalServerPort
    private int port;
    private WebTestClient testClient;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;

    @BeforeEach
    public void setUp() {
        testClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();

        Event event = new Event("67c9dee125301d1cb8215eee",
                "Teatro de sombras", LocalDateTime.now(),
                "70316-102","SHS Quadra 6 ","Asa Sul","Brasilia","DF");

        Ticket ticket = new Ticket("67ct4afac568c043fb36f555",
                "647.216.380-43",
                "Beatriz",
                "bia@gmail.com",
                event,
                50.0,10.0,"concluido");
        ticketRepository.save(ticket);
    }

    @AfterEach
    public void tearDown() {
        ticketRepository.deleteAll();
    }

    // --> GET

    @Test
    public void findTicket_WithValidId_ReturnStatus200() {
        Ticket responseBody = testClient
                .get()
                .uri("/Tickets/get-ticket/67ct4afac568c043fb36f555")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Ticket.class)
                .returnResult().getResponseBody();

        assert responseBody != null;
        assert responseBody.getTicketId() != null;
        assert responseBody.getTicketId().equals("67ct4afac568c043fb36f555");
    }

    @Test
    public void findEvent_InvalidId_ReturnStatus404() {
        testClient
                .get()
                .uri("/Tickets/get-ticket/67ct4afac568c043fb36f777")
                .exchange()
                .expectStatus().isNotFound();
    }

    // --> POST


}
