package com.rungroup.webTest.repositories;

import com.rungroup.webTest.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
