package com.rungroup.webTest.services.impl;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.mapper.MovieMapper;
import com.rungroup.webTest.models.Movie;
import com.rungroup.webTest.repositories.MovieRepository;
import com.rungroup.webTest.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rungroup.webTest.mapper.MovieMapper.mapToMovie;
import static com.rungroup.webTest.mapper.MovieMapper.mapToMovieDto;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(MovieMapper::mapToMovieDto).collect(Collectors.toList());
    }

    @Override
    public Movie saveMovie(MovieDto movieDto) {
        Movie movie = mapToMovie(movieDto);
        return movieRepository.save(movie);
    }

    @Override
    public MovieDto findMovieById(long movieId) {
        Movie movie = movieRepository.findById(movieId).get();
        return  mapToMovieDto(movie);
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        Movie movie = mapToMovie(movieDto);
        movieRepository.save(movie);
    }

    @Override
    public void delete(long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieDto> searchMovies(String query) {
        List<Movie> movies =  movieRepository.searchMovies(query);
        return movies.stream().map(MovieMapper::mapToMovieDto).collect(Collectors.toList());
    }

}
