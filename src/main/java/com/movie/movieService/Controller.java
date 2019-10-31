package com.movie.movieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    static List<Movie> movieList = new ArrayList<>();

    @GetMapping("/movies")
    public static List<Movie> getAllMovies(){
        return movieList;
    }

    @GetMapping("/movieId/{movieId}")
    public static Movie getMovieById(@PathVariable("movieId") int movieId){
        return movieList.stream().filter(movie -> movie.getId()==movieId).findFirst().orElse(null);
    }

    @PostMapping(value = "/addmovie", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public static String addMovie(@RequestBody Movie movieToAdd){
        movieList.add(movieToAdd);
        return "Movie Added";
    }
}
