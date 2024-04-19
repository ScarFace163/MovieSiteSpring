package com.rungroup.webTest.services.impl;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.models.Movie;
import com.rungroup.webTest.repositories.GenreRepository;
import com.rungroup.webTest.repositories.MovieRepository;
import com.rungroup.webTest.services.GenreService;

public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;
    private MovieRepository movieRepository;

    public GenreServiceImpl(GenreRepository genreRepository, MovieRepository movieRepository) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void createGenre(Long movieId, GenreDto genreDto) {
        Movie movie = movieRepository.findById(movieId);
    }
}
