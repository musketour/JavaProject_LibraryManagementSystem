package com.library.model;

public abstract class Item {
    private int id;
    private String title;
    private int publishedYear;
    private boolean availability;

    public Item(int id, String title, int publishedYear, boolean availability) {
        this.id = id;
        this.title = title;
        this.publishedYear = publishedYear;
        this.availability = availability;
    }

    public void checkin() {
        this.availability = true;
    }

    public void checkout() {
        this.availability = false;
    }

    public String getDetails() {
        return String.format("ID: %d, Title: %s, Year: %d, Available: %b", id, title, publishedYear, availability);
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPublishedYear() { return publishedYear; }
    public void setPublishedYear(int publishedYear) { this.publishedYear = publishedYear; }

    public boolean isAvailable() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }
}

