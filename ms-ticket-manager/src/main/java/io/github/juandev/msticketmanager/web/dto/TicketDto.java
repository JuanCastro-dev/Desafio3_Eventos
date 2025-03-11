package io.github.juandev.msticketmanager.web.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor
public class TicketDto {

    @CPF
    private String cpf;
    @Pattern(regexp = "^[a-zA-Z]+$") @NotNull
    private String customerName;
    @Email
    private String customerMail;
    private String eventId;
    private String eventName;
    private Long BrlTotalAmount;
    private Long UsdTotalAmount;

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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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
}
