package com.example.BookStore.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private long id;
    private String title;
    private String description;
    private float price;
    private Date publishedDate;
    private AuthorResponse author;
}
