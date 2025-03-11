package io.github.juandev.mseventmanager.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Document(collection = "tickets")
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
    @DBRef(lazy = true)
    private Event event;
    private Long BrlTotalAmount;
    private Long UsdTotalAmount;
    private String status = "Pendente";

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public @CPF String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF String cpf) {
        this.cpf = cpf;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public @Email String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(@Email String customerMail) {
        this.customerMail = customerMail;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getBrlTotalAmount() {
        return BrlTotalAmount;
    }

    public void setBrlTotalAmount(Long brlTotalAmount) {
        BrlTotalAmount = brlTotalAmount;
    }

    public Long getUsdTotalAmount() {
        return UsdTotalAmount;
    }

    public void setUsdTotalAmount(Long usdTotalAmount) {
        UsdTotalAmount = usdTotalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
