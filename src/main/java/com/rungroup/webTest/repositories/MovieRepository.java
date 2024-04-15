package com.rungroup.webTest.repositories;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    Optional<Movie> findByTitle(String url);
    @Query("SELECT c from Movie c WHERE c.title LIKE CONCAT('%' , :query , '%')")
    List <Movie> searchMovies(String query);
}
