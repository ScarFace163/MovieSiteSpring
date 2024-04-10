package com.rungroup.webTest.repositories;

import com.rungroup.webTest.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    Optional<Movie> findByTitle(String url);
}
