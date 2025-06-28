package com.example.BookStore.request;

import lombok.Data;

import java.util.Date;

/**
 * Represents the request payload for creating a new Book.
 * Includes details like title , description , price , published date , author id
 */
@Data
public class AddBookRequest {
    /**
     * Title of the book.
     */
    private String title;
    /**
     * Short description of th book.
     */
    private String description;
    /**
     * Price of the book.
     */
    private float price;
    /**
     * Date on which book was published
     */
    private Date publishedDate;
    /**
     * Id of the author who wrote book.
     */
    private long authorId;
}
