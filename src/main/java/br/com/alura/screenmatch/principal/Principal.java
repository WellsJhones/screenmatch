package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String apiKey = "&apikey=f52cf768";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();



    public void exibeMenu(){

        System.out.println("Digite o nome da serie: ");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + apiKey);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for(int i = 1; i<=dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados ( "https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }
        temporadas.forEach(System.out::println);

//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemporada= temporadas.get(i).episodios();
//            for(int j = 0; j < episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        }



    }
