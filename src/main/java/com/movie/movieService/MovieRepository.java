package com.movie.movieService;

import java.util.List;

public interface MovieRepository {

    int count();
    int save(Movie movie);
    int update(Movie movie);
    int deleteById(int id);
    List<Movie> getAll();
    Movie getById(int id);
    String geMoveNameById(int id);



}
