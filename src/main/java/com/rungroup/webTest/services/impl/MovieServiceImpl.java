package com.rungroup.webTest.services.impl;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.models.Movie;
import com.rungroup.webTest.repositories.MovieRepository;
import com.rungroup.webTest.services.MovieService;
import org.apache.catalina.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> findAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map((movie)->mapToMovieDto(movie)).collect(Collectors.toList());
    }

    @Override
    public Movie saveMovie(Movie movie) {
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

    private Movie mapToMovie(MovieDto movieDto) {
        return Movie.builder()
                .id (movieDto.getId())
                .title(movieDto.getTitle())
                .photoUrl(movieDto.getPhotoUrl())
                .description(movieDto.getDescription())
                .year(movieDto.getYear())
                .createdOn(movieDto.getCreatedOn())
                .updatedOn(movieDto.getUpdatedOn())
                .build();
    }

    private MovieDto mapToMovieDto(Movie movie){
        return MovieDto.builder()
                .id (movie.getId())
                .title(movie.getTitle())
                .photoUrl(movie.getPhotoUrl())
                .description(movie.getDescription())
                .year(movie.getYear())
                .createdOn(movie.getCreatedOn())
                .updatedOn(movie.getUpdatedOn())
                .build();
    }
}
