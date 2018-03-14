package com.mobylis.fr.repository;

import com.mobylis.fr.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory findOneByName(String name);
}
