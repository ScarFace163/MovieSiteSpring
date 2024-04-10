package com.rungroup.webTest.services;

import com.rungroup.webTest.dtos.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAllMovies();
}
