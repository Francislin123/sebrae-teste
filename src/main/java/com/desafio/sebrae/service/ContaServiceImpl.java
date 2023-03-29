package com.desafio.sebrae.service;

import com.desafio.sebrae.resources.request.ContaRequest;
import com.desafio.sebrae.resources.response.ContaResponse;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Override
    public ContaResponse criarConta(ContaRequest contaRequest) {
        return null;
    }

    @Override
    public boolean validaConta(ContaRequest contaRequest) {
        return false;
    }
}
