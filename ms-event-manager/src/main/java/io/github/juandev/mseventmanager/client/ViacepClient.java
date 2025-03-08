package io.github.juandev.mseventmanager.client;

import io.github.juandev.mseventmanager.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "viacepClient", url = "https://viacep.com.br/ws")
public interface ViacepClient {

    @GetMapping("/{cep}/json/")
    Address getAddressByCep(@PathVariable("cep") String cep);
}
