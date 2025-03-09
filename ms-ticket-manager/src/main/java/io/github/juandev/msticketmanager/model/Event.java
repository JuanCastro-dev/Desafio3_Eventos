package io.github.juandev.msticketmanager.model;

import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    private String id;
    private String eventName;
    private Date dateTime;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
