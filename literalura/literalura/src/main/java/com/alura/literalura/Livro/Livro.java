package com.alura.literalura.Livro;

import com.alura.literalura.Autor.Autor;
import com.alura.literalura.Autor.AutorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "autores_livros",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autor;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "livro_idioma", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "idioma")
    private List<String> idioma;

    private Double numeroDownloads;

    public Livro() {}

    public Livro(LivroDTO livro, List<AutorDTO> autores) {
        this.nome = livro.nomeLivro();
        this.numeroDownloads = livro.qtdDownloads();
        this.idioma = livro.idioma();
        this.autor = autores.stream().map(Autor::new).toList();
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

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-- LIVRO --\n")
                .append("Nome: ").append(this.getNome()).append("\n")
                .append("Autor(a): ");
        for (Autor autor : this.getAutor()) {
            sb.append(autor.getNome()).append(", ");
        }
        sb.append("\n")
                .append("Idioma: ").append(String.join(", ", this.getIdioma())).append("\n")
                .append("Número de downloads: ").append(this.getNumeroDownloads());
        return sb.toString();
    }
}
