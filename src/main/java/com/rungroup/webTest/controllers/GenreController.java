package com.rungroup.webTest.controllers;

import com.rungroup.webTest.dtos.GenreDto;
import com.rungroup.webTest.models.Genre;
import com.rungroup.webTest.services.GenreService;
import com.rungroup.webTest.services.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GenreController {
    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
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

}
