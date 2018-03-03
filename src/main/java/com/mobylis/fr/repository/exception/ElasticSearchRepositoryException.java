package com.mobylis.fr.repository.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
public class ElasticSearchRepositoryException extends RuntimeException {

    public ElasticSearchRepositoryException(String message) {
        super(message);
    }

}
