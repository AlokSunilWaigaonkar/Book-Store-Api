package com.example.BookStore.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 *Represents a response DTO containing author details.
 * Used to send author data back to client.
 */
@Data
@AllArgsConstructor
public class AuthorResponse {
    /**
     * Unique Identifier of the author.
     */
    private long id;
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
