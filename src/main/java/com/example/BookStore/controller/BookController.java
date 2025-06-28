package com.example.BookStore.controller;


import com.example.BookStore.request.AddBookRequest;
import com.example.BookStore.response.ApiResponse;
import com.example.BookStore.response.BookResponse;
import com.example.BookStore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class to handle all Book-related API requests.
 * This includes the operations like adding a book ,
 * fetching all books , fetching book by id , updating book by id ,
 * deleting specified book
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    /** Service layer dependency for book operations */
    private final BookService bookService;

    /**
     * Add a new book.
     *
     * @param request the object containing book details.
     * @return the response containing created book.
     */
    @PostMapping("/addBook")
    public ResponseEntity<ApiResponse<BookResponse>> addBook(@RequestBody AddBookRequest request) {
        return ResponseEntity.ok(bookService.addBook(request));
    }

    /**
     * Fetch all books.
     *
     * @return the response containing list of all books
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<BookResponse>>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    /**
     * Fetch book details for the specified id.
     *
     * @param id the unique identifier for book.
     * @return the response containing the book details.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBookById(@PathVariable Long id ){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    /**
     * Update the details of the book for specified id.
     *
     * @param id the unique identifier for book.
     * @param request the object containing book details.
     * @return the response containing updated book details.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(
            @PathVariable Long id,
            @RequestBody AddBookRequest request) {
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    /**
     * Delete book by the id.
     *
     * @param id the unique identifier for book.
     * @return the response containing status of the function.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    /**
     * Fetch all books by pagination.
     *
     * @param page the current page no.
     * @param size the number of records per page.
     * @return ApiResponse containing BookPaginationResponse.
     */
    @GetMapping("/books-page")
    public ApiResponse<?> getBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return bookService.getPaginatedBooks(page, size);
    }

}
