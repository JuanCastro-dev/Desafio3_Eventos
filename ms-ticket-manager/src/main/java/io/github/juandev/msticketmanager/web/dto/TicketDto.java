package io.github.juandev.msticketmanager.web.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


public class TicketDto {

    @CPF
    private String cpf;

    private String customerName;
    private String customerMail;
    private String eventId;
    private String eventName;
    private double BrlTotalAmount;
    private double UsdTotalAmount;

    public TicketDto() {}

    public TicketDto(String cpf, String customerName, String customerMail, String eventId, String eventName, double brlTotalAmount, double usdTotalAmount) {
        this.cpf = cpf;
        this.customerName = customerName;
        this.customerMail = customerMail;
        this.eventId = eventId;
        this.eventName = eventName;
        BrlTotalAmount = brlTotalAmount;
        UsdTotalAmount = usdTotalAmount;
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

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail( String customerMail) {
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
}
