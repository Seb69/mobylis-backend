package com.mobylis.fr.service.exception;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
public class ProductServiceException extends RuntimeException {

    public ProductServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductServiceException(String reason) {
        super(reason);
    }
}
