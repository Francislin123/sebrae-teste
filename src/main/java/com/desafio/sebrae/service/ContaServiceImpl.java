package com.desafio.sebrae.service;

import com.desafio.sebrae.exceptions.UserException;
import com.desafio.sebrae.repository.ContaRepository;
import com.desafio.sebrae.repository.conta.ContaEntity;
import com.desafio.sebrae.resources.request.ContaRequest;
import com.desafio.sebrae.resources.response.ContaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public ContaResponse criarConta(final ContaRequest contaRequest) {
        persistConta(this.getBuildConta(contaRequest));
        return ContaResponse.builder().nome(contaRequest.getNome()).descricao(contaRequest.getDescricao()).build();
    }

    @Override
    public ContaResponse atualizarConta(ContaRequest contaRequest) {

        final var conta = contaRepository.findByNome(contaRequest.getNome());

        final var contaEntity = ContaEntity.builder().id(conta.getId())
                .nome(contaRequest.getNome()).descricao(contaRequest.getDescricao()).build();

        contaRepository.save(contaEntity);

        return ContaResponse.builder().nome(contaRequest.getNome()).descricao(contaRequest.getDescricao()).build();
    }

    @Override
    public void deletarConta(final Long id) {
        contaRepository.delete(this.contaRepository.findById(id).orElseThrow(() ->
                new UserException(String.format("Conta nao encontrada pelo id='%s", id))));
    }

    @Override
    public ContaResponse pesquisarContarPorNome(String nome) {
        final var conta = this.contaRepository.findByNome(nome);
        if (conta != null) {
            return ContaResponse.builder().nome(conta.getNome()).descricao(conta.getDescricao()).build();
        }
        return null;
    }

    @Override
    public boolean validaConta(final ContaRequest contaRequest) {
        return Objects.isNull(this.contaRepository.findByNome(contaRequest.getNome()));
    }

    private void persistConta(final ContaEntity contaEntity) {
        ContaEntity conta = this.contaRepository.saveAndFlush(contaEntity);
        log.info("contaEntity={} message=insert_successfully", conta);
    }

    private ContaEntity getBuildConta(final ContaRequest contaRequest) {
        return ContaEntity.builder().nome(contaRequest.getNome()).descricao(contaRequest.getDescricao()).build();
    }
}
