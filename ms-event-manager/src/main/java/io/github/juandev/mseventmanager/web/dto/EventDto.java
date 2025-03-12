package io.github.juandev.mseventmanager.web.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

public class EventDto {

    private String eventName;
    private LocalDateTime dateTime;
    @Size(min = 9, max = 9, message = "Must follow the format: 00000-000")
    private String cep;

    public EventDto(){}

    public EventDto(String eventName, LocalDateTime dateTime, String cep) {
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.cep = cep;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public @Size(min = 9, max = 9, message = "Must follow the format: 00000-000") String getCep() {
        return cep;
    }

    public void setCep(@Size(min = 9, max = 9, message = "Must follow the format: 00000-000") String cep) {
        this.cep = cep;
    }
}
