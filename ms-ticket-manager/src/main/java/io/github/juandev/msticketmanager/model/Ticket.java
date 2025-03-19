package io.github.juandev.msticketmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "tickets")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String ticketId;
    @CPF
    private String cpf;
    private String customerName;
    private String customerMail;
    @DBRef(lazy = true)
    private Event event;
    private double BrlTotalAmount;
    private double UsdTotalAmount;
    private String status = "Pendente";

    public Ticket() {}

    public Ticket(String ticketId, String cpf, String customerName, String customerMail, Event event, double brlTotalAmount, double usdTotalAmount, String status) {
        this.ticketId = ticketId;
        this.cpf = cpf;
        this.customerName = customerName;
        this.customerMail = customerMail;
        this.event = event;
        BrlTotalAmount = brlTotalAmount;
        UsdTotalAmount = usdTotalAmount;
        this.status = status;
    }

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

    public  String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getBrlTotalAmount() {
        return BrlTotalAmount;
    }

    public void setBrlTotalAmount(double brlTotalAmount) {
        BrlTotalAmount = brlTotalAmount;
    }

    public double getUsdTotalAmount() {
        return UsdTotalAmount;
    }

    public void setUsdTotalAmount(double usdTotalAmount) {
        UsdTotalAmount = usdTotalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
