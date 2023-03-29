package com.desafio.sebrae.resources;

import com.desafio.sebrae.resources.request.ContaRequest;
import com.desafio.sebrae.resources.response.ContaResponse;
import com.desafio.sebrae.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ContaController.URI)
public class ContaController {

    public static final String URI = "/conta";

    private ContaService contaService;

    @RequestMapping(path = "/criar-conta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContaResponse> criarConta(@Valid @RequestBody ContaRequest contaRequest) {

        final var contaValidada = contaService.validaConta(contaRequest);

        if (!contaValidada) {
            return new ResponseEntity<>(ContaResponse.builder()
                    .descricao(contaRequest.getDescricao())
                    .nome(contaRequest.getNome()).build(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(contaService.criarConta(contaRequest), new HttpHeaders(), HttpStatus.CREATED);
    }
}
