package com.example.BookStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents a book entity in BookStore System
 * Contains the details of the book such as title ,
 * description , price , published date and author.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Title of the book.
     */
    private String title;
    /**
     * Short description of the book
     */
    private String description;
    /**
     * Price of the book
     */
    private float price;
    /**
     * Date on which book was published.
     */
    private Date publishedDate;

    /**
     *Author who wrote the book.
     * Mapped as many-to-one relationship with author.
     * Each book is written by one author.
     */
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
