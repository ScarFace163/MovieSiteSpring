package com.rungroup.webTest.controllers;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.models.Genre;
import com.rungroup.webTest.services.GenreService;
import com.rungroup.webTest.services.impl.GenreServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GenreController {
    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String genresList(Model model) {
        List<GenreDto> genres = genreService.findAllGenres();
        model.addAttribute("genres", genres);
        return "genres-list";
    }

    @GetMapping("/genres/{id}/new")
    public  String createGenreForm(@PathVariable("id") Long id , Model model){
        Genre genre = new Genre();
        model.addAttribute("id", id);
        model.addAttribute("genre" , genre);
        return "genres-create";
    }
    @PostMapping("/genres/{id}")
    public String createGenre(@PathVariable("id") Long id, @ModelAttribute("genre") GenreDto genreDto, Model model){
        genreService.createGenre(id,genreDto);
        return "redirect:/movies/" + id;
    }
    @GetMapping("/genres/{id}")
    public  String viewGenre(@PathVariable("id") Long id , Model model){
        GenreDto genreDto = genreService.findGenreById(id);
        model.addAttribute("genre" , genreDto);
        return "genre-detail";
    }

    @GetMapping("/genres/{id}/edit")
    public String editGenreForm(@PathVariable("id") long id , Model model){
        GenreDto genreDto = genreService.findGenreById(id);
        model.addAttribute("genre" , genreDto);
        return  "genres-edit";
    }
    @PostMapping("/genres/{id}/edit")
    public String updateGenre(@PathVariable("id") long genreId ,
                              @Valid @ModelAttribute("genre") GenreDto genre,
                              BindingResult result , Model model){
        if (result.hasErrors()){
            model.addAttribute("genre",genre);
            return "genres-edit";
        }
        GenreDto genreDto = genreService.findGenreById(genreId);
        genre.setId(genreId);
        genre.setMovie(genreDto.getMovie());
        genreService.updateGenre(genre);
        return "redirect:/movies";
    }
    @GetMapping ("/genres/{id}/delete")
    public String deleteMovie (@PathVariable("id") long id)
    {
        genreService.delete(id);
        return "redirect:/movies";
    }

}
