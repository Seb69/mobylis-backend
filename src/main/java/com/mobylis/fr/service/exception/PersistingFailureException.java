package com.mobylis.fr.service.exception;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public class PersistingFailureException extends RuntimeException {

    public PersistingFailureException(String message) {
        super(message);
    }

}
