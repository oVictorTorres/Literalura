package com.alura.literalura.Autor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByDataNascimentoBeforeAndDataFalecimentoAfterOrDataFalecimentoEquals(int anoNascimento, int anoFalecimento, int ano);

    @Query("Select a from Autor a")
    List<Autor> autoresCadastrados();

    @Query("SELECT a FROM Autor a WHERE a.dataNascimento <= :ano AND a.dataFalecimento >= :ano")
    List<Autor> autoresVivosNaqueleAno(int ano);
}