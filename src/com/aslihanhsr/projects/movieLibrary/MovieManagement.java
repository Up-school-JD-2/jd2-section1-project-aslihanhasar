package com.aslihanhsr.projects.movieLibrary;

import java.util.ArrayList;
import java.util.List;

public class MovieManagement {
    public final List<Movie> movies = new ArrayList<>();

    public void generateMovies() {
        movies.add(new Movie(1L, "Call Me by Your Name", "Drama", "Luca Guadagnino"
                , new String[]{"Armie Hammer", "Timothée Chalamet", "Michael Stuhlbarg"},
                "In 1980s Italy, romance blossoms between a seventeen-year-old student and the older man" +
                        " hired as his father's research assistant.", "2017"));

        movies.add(new Movie(2L, "Twelve Angry Men", "Drama", "Sidney Lumet"
                , new String[]{"Henry Fonda", "Lee J. Cobb", "Martin Balsam"},
                "The jury in a New York City murder trial is frustrated by a single member" +
                        "whose skeptical caution forces them to more carefully consider the evidence " +
                        "before jumping to a hasty verdict.", "1957"));
        movies.add(new Movie(3L, "Mandariinid", "Drama", "Zaza Urushadze"
                , new String[]{"Lembit Ulfsak", "Elmo Nüganen", "Giorgi Nakashidze"},
                "In 1992, war rages in Abkhazia, a breakaway region of Georgia. An Estonian man" +
                        " Ivo has decided to stay behind and harvest his crops of tangerines.", "2013"));

        movies.add(new Movie(4L, "Bulantı", "Drama", "Zeki Demirkubuz"
                , new String[]{"Zeki Demirkubuz", "Sebnem Hassanisoughi", "Öykü Karayel"},
                "Upon losing his wife and son, Ahmet has to struggle with the feeling of loneliness.", "2015"));

        movies.add(new Movie(5L, "And Then We Danced", "Romance", "Levan Akin"
                , new String[]{"Levan Gelbakhiani", "Bachi Valishvili", "Ana Javakishvili"},
                "A passionate coming-of-age tale set amidst the conservative confines of modern Tbilisi," +
                        "the film follows Merab, a competitive dancer who is thrown off balance by the arrival of " +
                        "Irakli, a fellow male dancer with a rebellious streak.", "2019"));

        movies.add(new Movie(6L, "The Nice Guys", "Comedy", "Shane Black"
                , new String[]{"Russell Crowe", "Ryan Gosling", "Angourie Rice"},
                "In 1970s Los Angeles, a mismatched pair of private eyes investigate a missing girl " +
                        "and the mysterious death of a porn star.", "2016"));

        movies.add(new Movie(7L, "Annihilation", "Adventure", "Alex Garland"
                , new String[]{"Natalie Portman", "Jennifer Jason Leigh", "Tessa Thompson"},
                "A biologist signs up for a dangerous, secret expedition into a mysterious zone" +
                        " where the laws of nature don't apply.", "2018"));

    }

    public void addMovieToLibrary(Movie movie) {
        long movieId = movie.getMovieId();
        Movie searchedMovie = searchMovieById(movieId);
        if (searchedMovie != null) {
            System.out.println("Movie already exists with this id.");
            return;
        }
        movies.add(movie);
        System.out.println("Movie has been added to the library");
    }

    public void removeMovieFromLibrary(String movieName, Long movieId) {
        Movie searchedMovie = searchMovieByName(movieName);
        if (searchedMovie == null) {
            System.out.println("Invalid movie name");
            return;
        }
        searchedMovie = searchMovieById(movieId);
        if (searchedMovie == null) {
            System.out.println("Mismatch movie name and id.");
            return;
        }
        movies.remove(searchedMovie);
        System.out.println("Movie has been deleted.");
    }

    public Movie searchMovieById(Long id) {
        Movie movie = null;
        for (Movie m : movies) {
            if (m.getMovieId().equals(id)) {
                movie = m;
            }
        }
        return movie;
    }

    public Movie searchMovieByName(String name) {
        Movie searchedMovie = null;
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(name)) {
                searchedMovie = movie;
            }
        }
        return searchedMovie;
    }

    public void listMovies() {
        System.out.println(movies);
    }

}
