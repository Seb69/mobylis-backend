package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findOneByName(String name);
}
