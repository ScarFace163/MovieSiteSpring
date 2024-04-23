package com.rungroup.webTest.mapper;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.models.Movie;

import java.util.stream.Collectors;

public class MovieMapper {
    public static Movie mapToMovie(MovieDto movieDto) {
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

    public static MovieDto mapToMovieDto(Movie movie){
        return MovieDto.builder()
                .id (movie.getId())
                .title(movie.getTitle())
                .photoUrl(movie.getPhotoUrl())
                .description(movie.getDescription())
                .year(movie.getYear())
                .createdOn(movie.getCreatedOn())
                .updatedOn(movie.getUpdatedOn())
                .genres(movie.getGenres().stream().map(GenreMapper::mapToGenreDto).collect(Collectors.toList()))
                .build();
    }
}
