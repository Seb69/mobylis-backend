package com.mobylis.fr.service.exception;


/**
 * @author ANDRE
 * @since 03/03/2018
 */
public class FileServiceException extends RuntimeException {
    public FileServiceException() {
        super();
    }
    public FileServiceException(String message) {
        super(message);
    }
    public FileServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
