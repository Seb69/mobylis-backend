package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@Repository
public interface DeskRepository extends JpaRepository<Deck,Long> {

}
