package net.javaguidelines.spring_annotations.beans;

// Class representing a Book entity with properties id, title, and description
public class Book {
    private int id;              // Unique identifier for the book
    private String title;        // Title of the book
    private String description;  // Description of the book

    // Constructor to initialize Book object with id, title, and description
    public Book(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getter method for the book's id
    public int getId() {
        return id;
    }

    // Setter method to set the book's id
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for the book's title
    public String getTitle() {
        return title;
    }

    // Setter method to set the book's title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for the book's description
    public String getDescription() {
        return description;
    }

    // Setter method to set the book's description
    public void setDescription(String description) {
        this.description = description;
    }
}
