package io.github.juandev.msticketmanager.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Document(collection = "tickets")
@Getter @Service
@NoArgsConstructor @AllArgsConstructor
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String ticketId;
    @CPF
    private String cpf;
    private String customerName;
    @Email
    private String customerMail;
    //Adicionar a classe de evento puxando do outro microsserviço
    private String eventName;
    private Long BrlTotalAmount;
    private Long UsdTotalAmount;
    private String status;
}
