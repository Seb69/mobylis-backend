package com.mobylis.fr.service.exception;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public class CategoryNotFound extends RuntimeException {
    public CategoryNotFound(String message) {
        super(message);
    }

}
