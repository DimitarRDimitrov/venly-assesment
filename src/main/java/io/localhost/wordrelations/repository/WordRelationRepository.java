package io.localhost.wordrelations.repository;

import io.localhost.wordrelations.model.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {
}
