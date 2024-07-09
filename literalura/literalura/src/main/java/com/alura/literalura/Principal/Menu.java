package com.alura.literalura.Principal;

import com.alura.literalura.Autor.Autor;
import com.alura.literalura.Autor.AutorService;
import com.alura.literalura.Livro.Livro;
import com.alura.literalura.Livro.LivroDTO;
import com.alura.literalura.Livro.LivroService;
import com.alura.literalura.Requisicao.ConsumoRequisicao;
import com.alura.literalura.Requisicao.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    private Scanner input = new Scanner(System.in);
    private Requisicao requisicao = new Requisicao();
    private ConsumoRequisicao consumoRequisicao = new ConsumoRequisicao();

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    public void principal() throws IOException, InterruptedException {
        String menu = """
                ===================================================================================================================
                Escolha o número de sua opção.
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros em determinado idioma
                0 - Sair
                ===================================================================================================================
                """;
        var escolha = 7;
        while (escolha != 0) {
            System.out.println(menu);
            escolha = input.nextInt();
            input.nextLine();
            switch (escolha) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Parando sistema...");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    private void buscarLivro() throws IOException, InterruptedException {
        System.out.println("Qual livro deseja buscar?");
        var busca = input.nextLine();
        var respostaJson = requisicao.consumoAPI(busca);

        try {
            LivroDTO livroDTO = consumoRequisicao.consumindo(respostaJson);

            Livro livroExistente = livroService.encontrarPorNome(livroDTO.nomeLivro());
            if (livroExistente == null) {
                Livro novoLivro = new Livro(livroDTO, livroDTO.autor());
                livroService.salvarLivro(novoLivro);
                System.out.println("Livro salvo no banco de dados.");
            } else {
                System.out.println("Livro já existe no banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar o livro: " + e.getMessage());
        }
    }

    private void listarLivrosRegistrados() {
        System.out.println("Listando livros registrados...");
        List<Livro> livros = livroService.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro.toString());
            }
        }
    }

    private void listarAutoresRegistrados() {
        System.out.println("Listando autores registrados...");
        List<Autor> autores = autorService.listarAutores();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            for (Autor autor : autores) {
                System.out.println(autor.toString());
                System.out.println("---------------");
            }
        }
    }

    private void listarAutoresVivos() {
        System.out.println("Digite o ano:");
        int ano = input.nextInt();
        input.nextLine(); // Consumir a nova linha

        System.out.println("Listando autores vivos em " + ano + "...");
        List<Autor> autores = autorService.listarAutoresVivos(ano);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor estava vivo em " + ano + ".");
        } else {
            for (Autor autor : autores) {
                System.out.println(autor.toString());
                System.out.println("---------------");
            }
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Digite o idioma:
                es - Espanhol
                en - Inglês
                fr - Francês
                pt - Português
                """);
        String idioma = input.nextLine();

        System.out.println("Listando livros em " + idioma + "...");
        List<Livro> livros = livroService.listarLivrosPorIdioma(idioma);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado no idioma " + idioma + ".");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro.toString());
            }
        }
    }
}
