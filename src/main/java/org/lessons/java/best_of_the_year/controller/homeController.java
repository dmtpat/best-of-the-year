package org.lessons.java.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.best_of_the_year.model.Movie;
import org.lessons.java.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/")
public class homeController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("io", new String("Patricia"));
        return "home";
    }

    private List<Movie> getBestMovies() {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie(1, "Shrek"));
        list.add(new Movie(2, "Matrix")); 
        list.add(new Movie(3, "Deadpool"));
        return list;
    }

    private List<Song> getBestSongs() {
        List<Song> list = new ArrayList<>();
        list.add(new Song(1, "Carry on"));
        list.add(new Song(2, "You're gonna go far kid"));
        list.add(new Song(3, "All Stars")); 
        return list;
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        String titles = new String("");
        List<Movie> moviesList = getBestMovies();
        for (Movie movie : moviesList) {
            if (titles.equals("")) {
                titles += movie.getTitolo();
            } else {

                titles += ", " + movie.getTitolo();
            }
        }
        model.addAttribute("titles", titles);
        
        return "movies";
    }
    @GetMapping("/songs")
    public String getSongs(Model model) {
        String titles = new String("");
        List<Song> songsList = getBestSongs();
        for (Song song : songsList) {
            if (titles.equals("")) {
                titles += song.getTitolo();
            } else {

                titles += ", " + song.getTitolo();
            }
        }
        model.addAttribute("titles", titles);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMoviesById(@PathVariable("id") int id, Model model) {
        String selected = new String();
        for (Movie movie : getBestMovies()) {
            if (movie.getId() == id) {
                selected = movie.getTitolo();
                break;
            }
        }
        model.addAttribute("selected", selected);
        model.addAttribute("type", "Il Film");
        return "selected";
    }
    
    @GetMapping("/songs/{id}")
    public String getSongsById(@PathVariable("id") int id, Model model) {
        String selected = new String();
        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                selected = song.getTitolo();
                break;
            }
        }
        model.addAttribute("selected", selected);
        model.addAttribute("type", "La Canzone");
        model.addAttribute("id", id);
        return "selected";
    }
    
}
