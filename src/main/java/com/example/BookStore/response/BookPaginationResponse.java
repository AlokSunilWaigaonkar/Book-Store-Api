package com.example.BookStore.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a paginated response for books.
 * Contains list of books and pagination metadata.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPaginationResponse {
    /**
     * List of all books of the current page.
     */
    private List<BookResponse> books;
    /**
     * The current page number (0-indexed).
     */
    private int currentPage;
    /**
     * Total number of pages available.
     */
    private int totalPages;
    /**
     * Total number of book records.
     */
    private long totalElements;
}