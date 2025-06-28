package com.example.BookStore.request;

import lombok.Data;

import java.util.Date;

/**
 * Represents the request payload for creating a new Author.
 * Includes basic details such as name , bio , date of birth
 */
@Data
public class AddAuthorRequest {
    /**
     * Full name of the author.
     */
    private String name;
    /**
     * Short bio of the author.
     */
    private String bio;
    /**
     * Date of birth of the author.
     */
    private Date dateOfBirth;
}
