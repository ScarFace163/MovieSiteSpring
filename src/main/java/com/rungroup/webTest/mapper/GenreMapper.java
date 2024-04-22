package com.rungroup.webTest.mapper;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.models.Genre;

public class GenreMapper {
    public static Genre mapToGenre(GenreDto genreDto) {
        return Genre.builder()
                .id(genreDto.getId())
                .type(genreDto.getType())
                .description(genreDto.getDescription())
                .build();
    }
    public static GenreDto mapToGenreDto(Genre genre) {
        return GenreDto.builder()
                .id(genre.getId())
                .type(genre.getType())
                .description(genre.getDescription())
                .build();
    }
}
