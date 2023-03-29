package com.desafio.sebrae.service;

import com.desafio.sebrae.resources.request.ContaRequest;
import com.desafio.sebrae.resources.response.ContaResponse;

import java.util.UUID;

public interface ContaService {

    ContaResponse criarConta(ContaRequest contaRequest);

    boolean validaConta(ContaRequest contaRequest);

    ContaResponse atualizarConta(ContaRequest contaRequest);

    void deletarConta(Long id);
}
