package io.github.juandev.mseventmanager;

import io.github.juandev.mseventmanager.model.Event;
import io.github.juandev.mseventmanager.repository.EventRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventIT {

    @Autowired
    private WebTestClient testClient;
    @Autowired
    private EventRepository eventRepository;

    @BeforeEach
    public void setUp() {
        Event event = new Event("67c9dee125301d1cb8215eee",
                "Teatro de sombras", LocalDateTime.now(),
                "70316-102","SHS Quadra 6 ","Asa Sul","Brasilia","DF");
        eventRepository.save(event);
    }

    @AfterEach
    public void tearDown() {
        eventRepository.deleteAll();
    }
}
