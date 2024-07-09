package com.alura.literalura.Requisicao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicao {
    static String LINK  = "https://gutendex.com/books/?search=";


    public String consumoAPI(String nomeLivro) throws IOException, InterruptedException {
        nomeLivro = nomeLivro.replace(" ", "%20");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LINK + nomeLivro))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = resposta.body();

        return json;
    }
}
