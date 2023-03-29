package com.desafio.sebrae.integration.resources;

import com.desafio.sebrae.integration.Endereco;
import com.desafio.sebrae.integration.FindCEPClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep")
public class CepController {

    private FindCEPClient findCEPClient;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> obterCep(@PathVariable("cep") String cep) {
        Endereco enderecoResponse = findCEPClient.buscaEnderecoPor(cep);
        return ResponseEntity.ok(enderecoResponse);
    }
}
