package io.localhost.wordrelations.repository;

import io.localhost.wordrelations.model.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {

    List<WordRelation> findByRelation(String relation);

    Optional<WordRelation> findByFirstWordAndSecondWord(String firstWord, String secondWord);
}
