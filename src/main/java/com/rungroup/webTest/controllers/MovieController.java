package com.rungroup.webTest.controllers;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.models.Movie;
import com.rungroup.webTest.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import java.util.List;

@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String listMovies(Model model){
        List<MovieDto> movies = movieService.findAllMovies();
        model.addAttribute("movies", movies);
        return "movies-list";
    }

    @GetMapping("/movies/new")
    public String createMovieForm(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "movie-create";
    }

    @PostMapping("/movies/new")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}/edit")
    public String editMovieForm(@PathVariable("id") long movieId , Model model){
        MovieDto movie = movieService.findMovieById(movieId);
        model.addAttribute("movie" , movie);
        return  "movies-edit";
    }
    @PostMapping("/movies/{id}/edit")
    public String updateMovie(@PathVariable("id") Long movieId , @ModelAttribute("movie") MovieDto movie){
        movie.setId(movieId);
        movieService.updateMovie(movie);
        return "redirect:/movies";
    }
}
