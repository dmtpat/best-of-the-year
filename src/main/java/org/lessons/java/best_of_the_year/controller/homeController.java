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
        list.add(new Movie(1, "Shrek", "https://pad.mymovies.it/filmclub/2001/05/033/locandinapg1.jpg"));
        list.add(new Movie(2, "Matrix", "https://m.media-amazon.com/images/M/MV5BN2NmN2VhMTQtMDNiOS00NDlhLTliMjgtODE2ZTY0ODQyNDRhXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg")); 
        list.add(new Movie(3, "Deadpool", "https://media.themoviedb.org/t/p/w220_and_h330_face/xhodjKn31o8xNwvc65pfhtcewFH.jpg"));
        return list;
    }

    private List<Song> getBestSongs() {
        List<Song> list = new ArrayList<>();
        list.add(new Song(1, "Carry On Wayward Son","https://t2.genius.com/unsafe/196x196/https%3A%2F%2Fimages.genius.com%2F77d835ae910460ed06022c1031cd48c0.619x619x1.jpg"));
        list.add(new Song(2, "You're gonna go far kid", "https://t2.genius.com/unsafe/196x196/https%3A%2F%2Fimages.genius.com%2F1512f3dc6e7f75fab76cdb5d208e615c.1000x1000x1.jpg"));
        list.add(new Song(3, "All Stars", "https://upload.wikimedia.org/wikipedia/en/1/16/All_star.jpg")); 
        return list;
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        // String titles = new String("");
        List<Movie> moviesList = getBestMovies();
        // for (Movie movie : moviesList) {
        //     if (titles.equals("")) {
        //         titles += movie.getTitolo();
        //     } else {

        //         titles += ", " + movie.getTitolo();
        //     }
        // }
        // model.addAttribute("titles", titles);
        model.addAttribute("moviesList", moviesList);
        return "movies";
    }
    @GetMapping("/songs")
    public String getSongs(Model model) {
        // String titles = new String("");
        List<Song> songsList = getBestSongs();
        // for (Song song : songsList) {
        //     if (titles.equals("")) {
        //         titles += song.getTitolo();
        //     } else {

        //         titles += ", " + song.getTitolo();
        //     }
        // }
        // model.addAttribute("titles", titles);
        model.addAttribute("songsList", songsList);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMoviesById(@PathVariable("id") int id, Model model) {
        Movie selected = null;
        for (Movie movie : getBestMovies()) {
            if (movie.getId() == id) {
                selected = movie;
                break;
            }
        }
        model.addAttribute("selected", selected);
        return "selected";
    }
    
    @GetMapping("/songs/{id}")
    public String getSongsById(@PathVariable("id") int id, Model model) {
        Song selected = null;
        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                selected = song;
                break;
            }
        }
        model.addAttribute("selected", selected);
        return "selected";
    }
    
}
