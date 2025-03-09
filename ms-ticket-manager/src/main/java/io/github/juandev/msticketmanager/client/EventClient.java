package io.github.juandev.msticketmanager.client;

import io.github.juandev.msticketmanager.model.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//configurar para o endereço publico depois
@FeignClient(name = "ms-event-manager", url = "http://localhost:8081")
public interface EventClient {

    @GetMapping(value = "/get-event/{id}")
    Event findById(@RequestParam String id);
}
