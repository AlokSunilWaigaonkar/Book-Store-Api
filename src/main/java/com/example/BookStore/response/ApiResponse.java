package com.example.BookStore.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * a generic API response wrapper to standardize structure of response.
 *
 * @param <T> the type of date being returned in response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    /**
     * Indicated whether the response was successful.
     */
    private boolean success;
    /**
     * A message about the results.
     */
    private String message;
    /**
     * The actual response data , if any
     */
    private T data;
}
