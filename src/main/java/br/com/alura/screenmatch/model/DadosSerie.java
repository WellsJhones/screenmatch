package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

@JasoIgnoreProperties(ignoreUnknown = true)

public record DadosSerie(@JsonAlias("titlee") String titulo,@JsonAlias("totalSeasons") int totoaTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
}
