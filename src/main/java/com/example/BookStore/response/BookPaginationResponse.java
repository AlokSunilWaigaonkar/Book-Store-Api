package com.example.BookStore.response;

import com.example.BookStore.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPaginationResponse {
    private List<BookResponse> books;
    private int currentPage;
    private int totalPages;
    private long totalElements;



    // Getters and Setters
}