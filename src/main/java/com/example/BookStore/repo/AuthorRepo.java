package com.example.BookStore.repo;

import com.example.BookStore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Author entities.
 * Provides crud operations through JpaRepository.
 */
@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    //Additional query methods can be defined if needed.
}
