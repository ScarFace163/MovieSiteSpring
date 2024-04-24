package com.rungroup.webTest.dtos;

import com.rungroup.webTest.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {
    private Long id;
    private String type;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Movie movie;
}
