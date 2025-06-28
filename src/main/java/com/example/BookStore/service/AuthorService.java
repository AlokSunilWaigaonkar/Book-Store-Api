package com.example.BookStore.service;

import com.example.BookStore.exception.ResourceNotFoundException;
import com.example.BookStore.model.Author;
import com.example.BookStore.repo.AuthorRepo;
import com.example.BookStore.request.AddAuthorRequest;
import com.example.BookStore.response.ApiResponse;
import com.example.BookStore.response.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to handle business logic to the author related operations.
 * Handles creation , fetching by id and fetching all authors
 */
@Service
@RequiredArgsConstructor
public class AuthorService {
    /**
     * Repository for author entity.
     */
    private final AuthorRepo authorRepo;

    /**
     * Fetch all authors from the repository.
     * @return ApiResponse containing list of AuthorResponse.
     */
    public ApiResponse<List<AuthorResponse>> getAllAuthors(){
        List<AuthorResponse> authors = authorRepo.findAll()
                .stream()
                .map(this::toAuthorResponse)
                .toList();

        return new ApiResponse<>(true,"Authors fetched successfully",authors);
    }

    /**
     * Fetch author by id .
     * @param id the unique identifier of author.
     * @return ResourceNotFoundException if author not found otherwise AuthorResponse
     */
    public ApiResponse<AuthorResponse> getAuthorById(Long id){
        Author author = authorRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Author not found"));
        return new ApiResponse<>(true,"Author fetched successfully",toAuthorResponse(author));
    }

    /**
     * Add a new author to the repository
     *
     * @param authorRequest request DTO containing the author details.
     * @return ApiResponse containing created Author response.
     */
    public ApiResponse<AuthorResponse> addAuthor(AddAuthorRequest authorRequest){
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setBio(authorRequest.getBio());
        author.setDateOfBirth(authorRequest.getDateOfBirth());
        authorRepo.save(author);

        return new ApiResponse<>(true, "Author added successfully", toAuthorResponse(author));
    }

    /**
     * Convert author entity to AuthorResponse DTO.
     *
     * @param author the Author entity.
     * @return AuthorResponse DTO
     */
    public AuthorResponse toAuthorResponse(Author author){
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBio(),
                author.getDateOfBirth()
        );
    }
}
