package com.example.BookStore.controller;

import com.example.BookStore.request.AddAuthorRequest;
import com.example.BookStore.response.ApiResponse;
import com.example.BookStore.response.AuthorResponse;
import com.example.BookStore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<ApiResponse<AuthorResponse>> addAuthor(@RequestBody AddAuthorRequest request) {
        return ResponseEntity.ok(authorService.addAuthor(request));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AuthorResponse>>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuthorResponse>> getAuthorById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}
