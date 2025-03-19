//package io.github.juandev.mseventmanager;

import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.repository.EventRepository;
import io.github.juandev.mseventmanager.web.dto.EventDto;
import io.github.juandev.mseventmanager.web.mapper.EventMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
/*
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventIT {

    @LocalServerPort
    private int port;
    private WebTestClient testClient;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;

    @BeforeEach
    public void setUp() {
        testClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();

        Event event = new Event("67c9dee125301d1cb8215eee",
                "Teatro de sombras", LocalDateTime.now(),
                "70316-102","SHS Quadra 6 ","Asa Sul","Brasilia","DF");
        eventRepository.save(event);
    }

    @AfterEach
    public void tearDown() {
        eventRepository.deleteAll();
    }

    // --> GET

    @Test
    public void findEvent_WithValidId_ReturnStatus200() {
        Event responseBody = testClient
                .get()
                .uri("/events/get-event/67c9dee125301d1cb8215eee")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Event.class)
                .returnResult().getResponseBody();

        assert responseBody != null;
        assert responseBody.getId() != null;
        assert responseBody.getId().equals("67c9dee125301d1cb8215eee");
    }

  @Test
    public void findEvent_InvalidId_ReturnStatus404() {
        testClient
                .get()
                .uri("/events/get-event/67c9dee125301d1cb8215xyz")
                .exchange()
                .expectStatus().isNotFound();
    }

    // --> POST

   @Test
    public void createEvent_WithValidData_ReturnStatus201(){
        EventDto eventTest = new EventDto("Circuito de drift", LocalDateTime.now(), "70393-900");

        Event responseBody = testClient
                .post()
                .uri("/events/create-event")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(eventTest)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Event.class)
                .returnResult().getResponseBody();

        assert responseBody != null;
        assert responseBody.getId() != null;
        assert responseBody.getEventName().equals(eventTest.getEventName());
        assert responseBody.getCep().equals(eventTest.getCep());
        assert responseBody.getDateTime().equals(eventTest.getDateTime());
    }

    @Test
    public void createEvent_WithInvalidCEP_ReturnStatus400(){
        EventDto eventTest = new EventDto("Circuito de drift", LocalDateTime.now(), "70393-9");

        testClient
                .post()
                .uri("/events/create-event")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(eventTest)
                .exchange()
                .expectStatus().isBadRequest();
    }

    // --> DELETE

    @Test
    public void deleteEvent_WithValidId_ReturnStatus204(){
        testClient
                .delete()
                .uri("/events/delete-event/67c9dee125301d1cb8215eee")
                .exchange()
                .expectStatus().isNoContent();
    }

   @Test
    public void deleteEvent_WithInvalidId_ReturnStatus404(){
        testClient
                .delete()
                .uri("/events/delete-event/67c9dee125301d1cb8215xyz")
                .exchange()
                .expectStatus().isNotFound();
    }

    // --> PUT

   @Test
    public void updateEvent_WithValidData_ReturnStatus200() {
        EventDto eventTest = new EventDto("Circuito de drift", LocalDateTime.now(), "70393-900");

        Event responseBody = testClient
                .put()
                .uri("/events/update-event/67c9dee125301d1cb8215eee")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(eventTest)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Event.class)
                .returnResult().getResponseBody();

        assert responseBody != null;
        assert responseBody.getId() != null;
        assert responseBody.getEventName().equals(eventTest.getEventName());
        assert responseBody.getCep().equals(eventTest.getCep());
        assert responseBody.getDateTime().equals(eventTest.getDateTime());
    }

   @Test
    public void updateEvent_WithInvalidId_ReturnStatus404() {
        EventDto eventTest = new EventDto("Circuito de drift", LocalDateTime.now(), "70393-900");

        testClient
                .put()
                .uri("/events/update-event/67c9dee125301d1cb8215xyz")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(eventTest)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void updateEvent_WithInvalidCEP_ReturnStatus400() {
        EventDto eventTest = new EventDto("Circuito de drift", LocalDateTime.now(), "70393-9");

        testClient
                .put()
                .uri("/events/update-event/67c9dee125301d1cb8215xyz")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(eventTest)
                .exchange()
                .expectStatus().isBadRequest();
    }


}

 */
