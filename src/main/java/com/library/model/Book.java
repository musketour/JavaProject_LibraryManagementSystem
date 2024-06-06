package com.library.model;

public class Book extends com.library.model.Item {
    private String author;
    private String ISBN;
    private String genre;
    private int numPage;

    public Book(int id, String title, int publishedYear, boolean availability, String author, String ISBN, String genre, int numPage) {
        super(id, title, publishedYear, availability);
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.numPage = numPage;
    }

    // Getters and Setters
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getNumPage() { return numPage; }
    public void setNumPage(int numPage) { this.numPage = numPage; }

    @Override
    public String getDetails() {
        return super.getDetails() + String.format(", Author: %s, ISBN: %s, Genre: %s, Pages: %d", author, ISBN, genre, numPage);
    }
}
