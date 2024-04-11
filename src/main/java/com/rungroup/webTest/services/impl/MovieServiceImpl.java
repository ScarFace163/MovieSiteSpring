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
