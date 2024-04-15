package com.rungroup.webTest.services;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.models.Movie;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAllMovies();
    Movie saveMovie(MovieDto movie);
    MovieDto findMovieById(long movieId);
    void updateMovie(MovieDto movie);
    void delete (long id);
    List<MovieDto> searchMovies(String query);
}
