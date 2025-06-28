package com.example.BookStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an author entity in the BookStore System.
 * Contains personal details and list of authored books.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Full name of the author
     */
    private String name;
    /**
     * Short bio of author.
     */
    private String bio;
    /**
     * Date of birth of author.
     */
    private Date dateOfBirth;
    /**
     * List of the books written by author.
     * Mapped by 'author' field in the Book entity.
     */
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}
