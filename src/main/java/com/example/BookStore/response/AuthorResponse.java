package com.example.BookStore.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AuthorResponse {
    private long id;
    private String name;
    private String bio;
    private Date dateOfBirth;
}
