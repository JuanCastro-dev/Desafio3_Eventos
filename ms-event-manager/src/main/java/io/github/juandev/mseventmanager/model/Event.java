package io.github.juandev.mseventmanager.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "event")
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String eventName;
    private LocalDateTime dateTime;
    @Size(min = 9, max = 9, message = "Must follow the format: 00000-000")
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Event() {}

    public Event(String id, String eventName, LocalDateTime dateTime, String cep, String logradouro, String bairro, String localidade, String uf) {
        this.id = id;
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public @Size(min = 9, max = 9, message = "Must follow the format: 00000-000") String getCep() {
        return cep;
    }

    public void setCep(@Size(min = 9, max = 9, message = "Must follow the format: 00000-000") String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
