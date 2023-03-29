package com.desafio.sebrae.service;

import com.desafio.sebrae.resources.request.ContaRequest;
import com.desafio.sebrae.resources.response.ContaResponse;

public interface ContaService {

    ContaResponse criarConta(ContaRequest contaRequest);

    boolean validaConta(ContaRequest contaRequest);
}
