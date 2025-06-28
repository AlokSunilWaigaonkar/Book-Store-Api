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

/**
 * Service class to manage business logic to handle book related operations.
 * Handles creation , fetching by id , update book , delete book , fetch all books
 */
@Service
@RequiredArgsConstructor
public class BookService {

    /**
     * Repository for book entity
     */
    private final BookRepo bookRepo;
    /**
     * Repository for author entity
     */
    private final AuthorRepo authorRepo;

    /**
     * Fetch all books in the repository
     * @return ApiResponse containing list of bookResponse DTO
     */
    public ApiResponse<List<BookResponse>> getAllBooks(){
        List<BookResponse> books = bookRepo.findAll()
                .stream()
                .map(this::toBookResponse)
                .collect(Collectors.toList());

        return new ApiResponse<>(true,"Books fetched successfully",books);

    }

    /**
     * Convert book entity to BookResponse DTO
     *
     * @param book the book entity
     * @return bookResponse
     */
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

    /**
     * Fetch book by given id
     *
     * @param id the unique identifier of book
     * @return ApiResponse containing book fetched by id otherwise ResourceNotFoundException
     */
    public ApiResponse<BookResponse> getBookById(Long id ){
        Book book = bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found with id " +id ));
        return new ApiResponse<>(true,"Book fetched successfully",toBookResponse(book));
    }

    /**
     * Add a new Book
     *
     * @param bookRequest the BookRequest DTO
     * @return ApiResponse containing BookResponse DTO
     */
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

    /**
     * Update an existing book by id.
     *
     * @param id the id of the book to be updated.
     * @param bookRequest the updated book data.
     * @return ApiResponse containing updated book data.
     */
    public ApiResponse<BookResponse> updateBook(Long id , AddBookRequest bookRequest){
        Book book = bookRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));
        Author author = authorRepo.findById(bookRequest.getAuthorId())
                .orElseThrow(()->new ResourceNotFoundException("Author not found"));
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        book.setAuthor(author);

        bookRepo.save(book);
        return new ApiResponse<>(true,"Book updated successfully",toBookResponse(book));
    }

    /**
     * Delete a book  by id.
     * @param id the id of the book to be deleted
     * @return ApiResponse with success message
     */
    public ApiResponse<Void> deleteBook(Long id){
        Book book = bookRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Book not found"));
        bookRepo.delete(book);
        return new ApiResponse<>(true,"Book deleted successfully " , null);
    }

    /**
     * Fetch a pagination list of books
     * @param page the current page number
     * @param size the number of records per page
     * @return ApiResponse containing BookPaginationResponse
     */
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
