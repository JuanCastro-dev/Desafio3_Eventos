package io.github.juandev.msticketmanager.web.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TicketDto {

    private String ticketId;
    @CPF
    private String cpf;
    private String customerName;
    @Email
    private String customerMail;
    private String eventId;
    private String eventName;
    private Long BrlTotalAmount;
    private Long UsdTotalAmount;
}
