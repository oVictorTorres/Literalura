package com.alura.literalura.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l")
    List<Livro> livrosCadastrados();

    @Query("SELECT l FROM Livro l JOIN l.idioma i WHERE i = :idiomaEscolhido")
    List<Livro> livrosPorIdioma(@Param("idiomaEscolhido") String idiomaEscolhido);

    Livro findByNome(String nome);

    List<Livro> findByIdioma(String idioma);
}