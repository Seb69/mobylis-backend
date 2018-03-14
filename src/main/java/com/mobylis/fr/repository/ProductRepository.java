package com.mobylis.fr.repository;

import com.mobylis.fr.domain.ProductMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductMysql, Long> {

    List<ProductMysql> findAllByCategory_Name(@Param("name") String name);
}
