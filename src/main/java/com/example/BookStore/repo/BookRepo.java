package com.example.BookStore.repo;

import com.example.BookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Book entities.
 * Provides CRUD operations through JpaRepository.
 */
@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    //Additional query methods can be defined if needed.
}
