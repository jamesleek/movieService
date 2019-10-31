package com.movie.movieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieRepository implements MovieRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from movies", Integer.class);
    }

    @Override
    public int save(Movie movie) {
        return jdbcTemplate.update("insert into movies(id,title,releaseDate,genre) values (?,?,?,?)", movie.getId(),movie.getTitle(),movie.getReleaseDate(),movie.getGenre());
    }

    @Override
    public int update(Movie movie) {
        return jdbcTemplate.update("update movies set title = ?, where id=?",movie.getTitle(),movie.getId());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete movies where id=?",id);
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query("select * from movies",
                (rs, rowNum) -> new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("releaseDate"),
                        rs.getString("genre")
                )
        );
    }

    @Override
    public Movie getById(int id) {
        return jdbcTemplate.queryForObject("select * from movies where id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("releaseDate"),
                        rs.getString("genre")
                )

        );
    }

    @Override
    public String geMoveNameById(int id) {
        return jdbcTemplate.queryForObject("select name from movies where id = ?",
                new Object[]{id},
                String.class
        );
    }


}
