package com.rungroup.webTest.services;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.models.Genre;

import java.util.List;

public interface GenreService {
    void createGenre(Long movieId, GenreDto genreDto);

    List<GenreDto> findAllGenres();
}