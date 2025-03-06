package io.github.juandev.mseventmanager.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "event")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String eventName;
    private Date dateTime;
    @Size(min = 9, max = 9, message = "Must follow the format: 00000-000")
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
}
