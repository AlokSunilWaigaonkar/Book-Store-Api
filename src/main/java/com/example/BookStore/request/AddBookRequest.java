package com.example.BookStore.request;

import lombok.Data;

import java.util.Date;

@Data
public class AddBookRequest {
    private String title;
    private String description;
    private float price;
    private Date publishedDate;
    private long authorId;
}
