package net.javaguidelines.spring_annotations.controllers;

import net.javaguidelines.spring_annotations.beans.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController is a combination of @Controller and @ResponseBody, suitable for RESTful APIs
@RestController
@RequestMapping("/api") // Base URL path for all endpoints in this controller
public class BookController {

    // Simple GET endpoint returning a plain text "Hello World" message
    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    // GET endpoint that returns a Book object as JSON
    // The endpoint can be accessed by any of the listed paths: /book, /core-java, or /java
    @GetMapping(value = {"/book", "/core-java", "/java"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook() {
        // Creates a new Book object and returns it as the response body
        return new Book(1, "Core Java", "Learn core Java and features");
    }

    // POST endpoint for creating a new Book object
    // Expects JSON input in the request body and returns the created Book object with a 201 status
    @PostMapping(value = "/books/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Logs book details to the console
        System.out.println(book.getId());
        System.out.println(book.getTitle());
        System.out.println(book.getDescription());
        // Returns the created book object with HTTP status 201 (CREATED)
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // PUT endpoint for updating an existing Book object
    // Accepts a book ID as a path variable and the updated book data in the request body
    @PutMapping(value = "/books/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        // Logs the ID and updated details to the console
        System.out.println(id);
        System.out.println(updatedBook.getTitle());
        System.out.println(updatedBook.getDescription());
        // Updates the ID of the book and returns the updated book with HTTP status 200 (OK)
        updatedBook.setId(id);
        return ResponseEntity.ok(updatedBook);
    }

    // DELETE endpoint for deleting a Book object by ID
    // Responds with a success message upon deletion
    @DeleteMapping(value = "/books/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        // Logs the ID of the book to be deleted
        System.out.println(id);
        // Returns a success message with HTTP status 200 (OK)
        return ResponseEntity.ok("Book deleted successfully");
    }
}
