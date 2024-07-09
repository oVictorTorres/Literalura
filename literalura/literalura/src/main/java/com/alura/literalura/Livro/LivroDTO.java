package com.alura.literalura.Livro;

import com.alura.literalura.Autor.AutorDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(  @JsonAlias("title")String nomeLivro,
                         @JsonAlias("download_count") Double qtdDownloads,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias("authors") List<AutorDTO> autor) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(nomeLivro).append("\n");
        sb.append("Autor: ");
        for (int i = 0; i < autor.size(); i++) {
            sb.append(autor.get(i).toString());
            if (i < autor.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\n");
        sb.append("Idioma: ").append(String.join(", ", idioma)).append("\n");
        sb.append("Número de Downloads: ").append(qtdDownloads).append("\n");
        return sb.toString();
    }
}
