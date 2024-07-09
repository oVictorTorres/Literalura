package com.alura.literalura.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivos(int ano) {
        return autorRepository.findByDataNascimentoBeforeAndDataFalecimentoAfterOrDataFalecimentoEquals(ano, ano, 0);
    }
}
