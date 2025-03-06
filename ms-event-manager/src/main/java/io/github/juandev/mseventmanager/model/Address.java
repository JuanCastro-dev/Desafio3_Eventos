package io.github.juandev.mseventmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Address {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
