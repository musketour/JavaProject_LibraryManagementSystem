package com.library.model;

public class Journal extends com.library.model.Item {
    private String editor;
    private String ISSN;

    public Journal(int id, String title, int publishedYear, boolean availability, String editor, String ISSN) {
        super(id, title, publishedYear, availability);
        this.editor = editor;
        this.ISSN = ISSN;
    }

    // Getters and Setters
    public String getEditor() { return editor; }
    public void setEditor(String editor) { this.editor = editor; }

    public String getISSN() { return ISSN; }
    public void setISSN(String ISSN) { this.ISSN = ISSN; }

    @Override
    public String getDetails() {
        return super.getDetails() + String.format(", Editor: %s, ISSN: %s", editor, ISSN);
    }
}

