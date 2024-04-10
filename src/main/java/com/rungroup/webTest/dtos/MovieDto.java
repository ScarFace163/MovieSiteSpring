package com.rungroup.webTest.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private String photoUrl;
    private String description;
    private Integer year;
    private LocalDateTime createdOn;
    private LocalDateTime  updatedOn;
}
