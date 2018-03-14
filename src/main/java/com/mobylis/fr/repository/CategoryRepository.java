package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Resource
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findOneByName(String name);
}
