package com.desafio.sebrae.resources.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContaResponse {

    public String nome;

    public String descricao;
}
