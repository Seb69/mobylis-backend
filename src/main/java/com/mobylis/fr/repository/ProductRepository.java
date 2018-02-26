package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.repository.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@RepositoryRestResource(excerptProjection = ProductProjection.class)
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByCategory_Name(@Param("name") String name);
}
