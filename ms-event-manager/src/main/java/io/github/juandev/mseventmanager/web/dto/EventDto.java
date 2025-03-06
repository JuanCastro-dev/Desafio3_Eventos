package io.github.juandev.mseventmanager.web.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EventDto {

    private String eventName;
    private Date dateTime;
    @Size(min = 9, max = 9, message = "Must follow the format: 00000-000")
    private String cep;
}
