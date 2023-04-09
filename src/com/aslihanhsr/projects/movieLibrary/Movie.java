package com.aslihanhsr.projects.movieLibrary;

import java.util.Arrays;

public class Movie {
    private final Long movieId;
    private final String title;
    private final String releaseDate;
    private final String director;
    private final String movieType;
    private final String[] stars;
    private String overview;

    public Movie(Long movieId, String title, String movieType, String director, String[] stars, String overview, String releaseDate) {
        this.movieId = movieId;
        this.title = title;
        this.movieType = movieType;
        this.director = director;
        this.stars = stars;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public String[] getStars() {
        return stars;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getMovieType() {
        return movieType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Movie Id : ").append(movieId).append('\n');
        sb.append("Movie Name : ").append(title).append('\n');
        sb.append("Movie Type : ").append(movieType).append('\n');
        sb.append("Creators : ").append(director).append('\n');
        sb.append("Stars :").append(Arrays.toString(stars)).append('\n');
        sb.append("Overview :").append(overview).append('\n');
        sb.append("Release Year :").append(releaseDate).append('\n');
        sb.append("\n");
        return sb.toString();
    }
}
