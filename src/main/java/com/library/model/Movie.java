package com.library.model;

public class Movie extends com.library.model.Item {
    private String director;
    private int duration;

    public Movie(int id, String title, int publishedYear, boolean availability, String director, int duration) {
        super(id, title, publishedYear, availability);
        this.director = director;
        this.duration = duration;
    }

    // Getters and Setters
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public String getDetails() {
        return super.getDetails() + String.format(", Director: %s, Duration: %d minutes", director, duration);
    }
}

