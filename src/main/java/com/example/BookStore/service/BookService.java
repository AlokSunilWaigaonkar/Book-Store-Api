package com.example.BookStore.service;

import com.example.BookStore.exception.ResourceNotFoundException;
import com.example.BookStore.model.Author;
import com.example.BookStore.model.Book;
import com.example.BookStore.repo.AuthorRepo;
import com.example.BookStore.repo.BookRepo;
import com.example.BookStore.request.AddBookRequest;
import com.example.BookStore.response.ApiResponse;
import com.example.BookStore.response.AuthorResponse;
import com.example.BookStore.response.BookPaginationResponse;
import com.example.BookStore.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public ApiResponse<List<BookResponse>> getAllBooks(){
        List<BookResponse> books = bookRepo.findAll()
                .stream()
                .map(this::toBookResponse)
                .collect(Collectors.toList());

        return new ApiResponse<>(true,"Books fetched successfully",books);

    }
    public BookResponse toBookResponse(Book book){
        Author author = book.getAuthor();
        AuthorResponse authorResponse = new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBio(),
                author.getDateOfBirth()
        );
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getPrice(),
                book.getPublishedDate(),
                authorResponse
        );
    }

    public ApiResponse<BookResponse> getBookById(Long id ){
        Book book = bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found with id " +id ));
        return new ApiResponse<>(true,"Book fetched successfully",toBookResponse(book));
    }

    public ApiResponse<BookResponse> addBook(AddBookRequest bookRequest){
        Author author = authorRepo.findById(bookRequest.getAuthorId())
                .orElseThrow(()->new ResourceNotFoundException("Author not found"));
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        book.setAuthor(author);

        bookRepo.save(book);
        return new ApiResponse<>(true,"Book added successfully ",toBookResponse(book));
    }

    public ApiResponse<BookResponse> updateBook(Long id , AddBookRequest bookRequest){
        Book book = bookRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));
        Author author = authorRepo.findById(bookRequest.getAuthorId())
                .orElseThrow(()->new ResourceNotFoundException("Author not found"));
        book.setTitle(bookRequest.getTitle());
        book.setDescription(book.getDescription());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        book.setAuthor(author);

        bookRepo.save(book);
        return new ApiResponse<>(true,"Book updated successfully",toBookResponse(book));
    }

    public ApiResponse<Void> deleteBook(Long id){
        Book book = bookRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));
        bookRepo.delete(book);
        return new ApiResponse<>(true,"Book deleted successfully " , null);
    }

    public ApiResponse<BookPaginationResponse> getPaginatedBooks(int page, int size) {
        Page<Book> bookPage = bookRepo.findAll(PageRequest.of(page, size));

        List<BookResponse> bookResponses =  bookPage.getContent().stream()
                .map(this::toBookResponse)
                .toList();

        BookPaginationResponse paginationData = new BookPaginationResponse(
                 bookResponses,
                bookPage.getNumber(),
                bookPage.getTotalPages(),
                bookPage.getTotalElements()
        );

        return new  ApiResponse<>(true,"Books fetched successfully", paginationData);
    }

}
