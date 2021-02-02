package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repository.GenreRepository;
import com.cybertek.repository.MovieCinemaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class WebFluxController {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8282/api").build();

    private MovieCinemaRepository movieCinemaRepository;
    private GenreRepository genreRepository;

    public WebFluxController(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") Long id) {

        return Mono.just(movieCinemaRepository.findById(id).get());


    }


    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@PathVariable("id") Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @PostMapping("create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {
        Genre createdGenre = genreRepository.save(genre);
        return Mono.just(createdGenre);
    }

    @PutMapping("/update-genre")
    public Mono<Genre> updateGenre(@RequestBody Genre genre) {
        Genre updatedGenre = genreRepository.save(genre);

        return Mono.just(updatedGenre);
    }

    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }

    /*
    WEBCLIENT EXAMPLE//Consuming api samples
     */

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient() {


        return webClient.get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);

    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id) {
        return webClient.get()
                .uri("mono-movie-cinema/{id}", id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @GetMapping("/mono-rp")
    public Mono<MovieCinema> readMonoWithWebClientRequestParam(@RequestParam("id") Long id){

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                .path("/mono-movie-cinema")
                .queryParam("id",id)
                .build())
                .retrieve()
                .bodyToMono(MovieCinema.class);

    }


}
