package com.example.BookStore.controller;

import com.example.BookStore.request.AddAuthorRequest;
import com.example.BookStore.response.ApiResponse;
import com.example.BookStore.response.AuthorResponse;
import com.example.BookStore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class to handle Author related API requests
 * This include operations like adding author ,
 * fetching all authors and fetching by id
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    /** Service layer dependency for author operations */
    private final AuthorService authorService;

    // ------------------------------------------------------
    // Public API Endpoints
    // ------------------------------------------------------

    /**
     * Add a new author.
     *
     * @param request the request object containing author details.
     * @return the response containing the created author.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<AuthorResponse>> addAuthor(@RequestBody AddAuthorRequest request) {
        return ResponseEntity.ok(authorService.addAuthor(request));
    }

    /**
     * Fetch all  authors details .
     *
     * @return the response containing list of all authors.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<AuthorResponse>>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    /**
     * Fetch author details for given id.
     *
     * @param id the unique identifier of author.
     * @return the response containing the author's details.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponse>> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}
