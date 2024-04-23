package com.rungroup.webTest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String photoUrl;
    private String description;
    private Long year;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private LocalDateTime createdOn;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<Genre> genres = new ArrayList<>();
}