package io.github.juandev.mseventmanager.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ticketId;
    private String cpf;
    private String customerName;
    private String customerMail;
    private Long BrlTotalAmount;
    private Long UsdTotalAmount;
    private String status = "Pendente";

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf( String cpf) {
        this.cpf = cpf;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail( String customerMail) {
        this.customerMail = customerMail;
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
