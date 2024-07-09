package com.alura.literalura.Autor;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AutorDTO(
        @JsonAlias("name") String nomeAutor,
        @JsonAlias("birth_year") int anoNascimento,
        @JsonAlias("death_year") Integer anoFalecimento
) {
    @Override
    public String toString() {
        return String.format("%s", nomeAutor);
    }
}
