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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepo authorRepo;

    public ApiResponse<List<AuthorResponse>> getAllAuthors(){
        List<AuthorResponse> authors = authorRepo.findAll()
                .stream()
                .map(this::toAuthorResponse)
                .toList();

        return new ApiResponse<>(true,"Authors fetched successfully",authors);
    }

    public ApiResponse<AuthorResponse> getAuthorById(Long id){
        Author author = authorRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Author not found"));
        return new ApiResponse<>(true,"Auhtor fetched successfully",toAuthorResponse(author));
    }

    public ApiResponse<AuthorResponse> addAuthor(AddAuthorRequest authorRequest){
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setBio(authorRequest.getBio());
        author.setDateOfBirth(authorRequest.getDateOfBirth());
        authorRepo.save(author);

        return new ApiResponse<>(true, "Author added successfully", toAuthorResponse(author));
    }

    public AuthorResponse toAuthorResponse(Author author){
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBio(),
                author.getDateOfBirth()
        );
    }
}
