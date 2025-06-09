package com.example.BookStore.controller;


import com.example.BookStore.model.Book;
import com.example.BookStore.repo.BookRepo;
import com.example.BookStore.request.AddBookRequest;
import com.example.BookStore.response.ApiResponse;
import com.example.BookStore.response.BookResponse;
import com.example.BookStore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookRepo bookRepo;

    @PostMapping("/addBook")
    public ResponseEntity<ApiResponse<BookResponse>> addBook(@RequestBody AddBookRequest request) {
        return ResponseEntity.ok(bookService.addBook(request));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<BookResponse>>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBookById(@PathVariable Long id ){
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(
            @PathVariable Long id,
            @RequestBody AddBookRequest request) {
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
    @GetMapping("/books-page")
    public ApiResponse<?> getBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return bookService.getPaginatedBooks(page, size);
    }

}
