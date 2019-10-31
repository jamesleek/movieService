package com.movie.movieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MovieServiceApplication {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Qualifier
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	public void runJDBC(){

		jdbcTemplate.execute("DROP TABLE movies IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE movies(" +
				"id SERIAL, title VARCHAR(255),releaseDate VARCHAR(255),genre VARCHAR(255)))");
	}

}
