package com.alura.literalura.Requisicao;

import com.alura.literalura.Livro.LivroDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumoRequisicao {
    public LivroDTO consumindo(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var modulo = mapper.readTree(json);
        var receptor = modulo.get("results").get(0);
        System.out.println("Receptor JSON: " + receptor.toString());

        LivroDTO livroDTO = mapper.treeToValue(receptor, LivroDTO.class);

        System.out.println("LivroDTO criado: " + livroDTO.toString());

        return livroDTO;
    }
}
