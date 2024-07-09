package com.alura.literalura.Autor;

import com.alura.literalura.Livro.Livro;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    private int dataNascimento;
    private int dataFalecimento;

    @ManyToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros;

    public Autor() {}

    public Autor(AutorDTO autor) {
        this.nome = autor.nomeAutor();
        this.dataFalecimento = autor.anoFalecimento();
        this.dataNascimento = autor.anoNascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(int dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        String livrosEscritos = livros.stream()
                .map(Livro::getNome)
                .collect(Collectors.joining(", "));
        return String.format("Nome: %s\nData de Nascimento: %d\nData de Falecimento: %d\nLivros:[%s]",
                nome, dataNascimento, dataFalecimento == 0 ? "N/A" : dataFalecimento, livrosEscritos.isEmpty() ? "Nenhum livro encontrado" : livrosEscritos);
    }
}
