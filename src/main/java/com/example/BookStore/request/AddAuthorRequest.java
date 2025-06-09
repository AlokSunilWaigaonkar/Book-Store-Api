package com.example.BookStore.request;

import lombok.Data;

import java.util.Date;

@Data
public class AddAuthorRequest {
    private String name;
    private String bio;
    private Date dateOfBirth;
}
