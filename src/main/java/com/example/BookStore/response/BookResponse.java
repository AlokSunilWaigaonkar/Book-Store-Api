package com.example.BookStore.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents a response DTO containing book details.
 * Used to send Book details back to client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    /**
     * Unique identifier of the book.
     */
    private long id;
    /**
     * Title of the book.
     */
    private String title;
    /**
     * Short description of the book.
     */
    private String description;
    /**
     * Price of the book.
     */
    private float price;
    /**
     * Date on which book was published.
     */
    private Date publishedDate;
    /**
     * Author who wrote the book.
     */
    private AuthorResponse author;
}
