package com.rungroup.webTest.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;

@Data
@Builder
public class MovieDto {
    private Long id;
    @NotEmpty(message = "Movie tittle should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Movie description should not be empty")
    private String description;
    @Min(value = 1895, message = "Minimum year is 1895")
    @Max(value = 2024, message = "Maximum year is 2024")
    private Long year;
    private LocalDateTime createdOn;
    private LocalDateTime  updatedOn;
    private List<GenreDto> genres;
}
