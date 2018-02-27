package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Product;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public interface CrudRepository {
    Product save(Product product);
    void delete(Product product);
    Product update(Product product);
}
