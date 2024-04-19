package com.rungroup.webTest.services.impl;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.models.Genre;
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
        Movie movie = movieRepository.findById(movieId).get();
        Genre genre = mapToGenre(genreDto);
        genre.setMovie(movie);
        genreRepository.save(genre);
    }
    private Genre mapToGenre(GenreDto genreDto) {
        return Genre.builder()
                .id(genreDto.getId())
                .type(genreDto.getType())
                .description(genreDto.getDescription())
                .build();
    }
}
