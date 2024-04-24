package com.rungroup.webTest.services.impl;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.mapper.GenreMapper;
import com.rungroup.webTest.models.Genre;
import com.rungroup.webTest.models.Movie;
import com.rungroup.webTest.repositories.GenreRepository;
import com.rungroup.webTest.repositories.MovieRepository;
import com.rungroup.webTest.services.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rungroup.webTest.mapper.GenreMapper.mapToGenre;
import static com.rungroup.webTest.mapper.GenreMapper.mapToGenreDto;
import static com.rungroup.webTest.mapper.MovieMapper.mapToMovie;
import static com.rungroup.webTest.mapper.MovieMapper.mapToMovieDto;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final MovieRepository movieRepository;

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

    @Override
    public List<GenreDto> findAllGenres() {
        List <Genre> genres = genreRepository.findAll();
        return  genres.stream().map(GenreMapper::mapToGenreDto).collect(Collectors.toList());
    }
    @Override
    public GenreDto findGenreById(long genreId) {
        Genre genre = genreRepository.findById(genreId).get();
        return  mapToGenreDto(genre);
    }
    @Override
    public void updateGenre(GenreDto genreDto) {
        Genre genre = mapToGenre(genreDto);
        genreRepository.save(genre);
    }
}
