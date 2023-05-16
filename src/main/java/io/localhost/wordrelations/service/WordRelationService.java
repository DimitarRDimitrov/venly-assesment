package io.localhost.wordrelations.service;

import io.localhost.wordrelations.exception.InverseRelationExistsException;
import io.localhost.wordrelations.model.WordRelation;
import io.localhost.wordrelations.model.WordRelationRequest;
import io.localhost.wordrelations.repository.WordRelationRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordRelationService {

    private final WordRelationRepository wordRelationRepository;


    public WordRelationService(WordRelationRepository wordRelationRepository) {
        this.wordRelationRepository = wordRelationRepository;
    }

    public List<WordRelation> getAllWordRelations(String relationFilter, Boolean includeInversion) {
        List<WordRelation> filteredWordRelations = getFilteredWordRelations(relationFilter);

        if (includeInversion) {
            List<WordRelation> inverseRelations = filteredWordRelations.stream()
                    .map(this::buildInverseRelation)
                    .toList();

            filteredWordRelations.addAll(inverseRelations);
        }

        return filteredWordRelations;
    }

    public Long createWordRelation(WordRelationRequest newWordRelationRequest) {
        validateInverseRelationNotExists(newWordRelationRequest);

        WordRelation newWordRelation = buildWorldRelationFromRequest(newWordRelationRequest);

        return wordRelationRepository.save(newWordRelation).getId();
    }

    private void validateInverseRelationNotExists(WordRelationRequest newWordRelationRequest) {
        Optional<WordRelation> byFirstWordAndSecondWord = wordRelationRepository
                .findByFirstWordAndSecondWord(newWordRelationRequest.getSecondWord(), newWordRelationRequest.getFirstWord());

        if (byFirstWordAndSecondWord.isPresent()) {
            throw new InverseRelationExistsException();
        }
    }

    private List<WordRelation> getFilteredWordRelations(String relationFilter) {
        if (Strings.isBlank(relationFilter)) {
            return wordRelationRepository.findAll();
        }

        return wordRelationRepository.findByRelation(relationFilter);
    }

    private WordRelation buildWorldRelationFromRequest(WordRelationRequest newWordRelationRequest) {
        WordRelation newWordRelation = new WordRelation();
        newWordRelation.setFirstWord(newWordRelationRequest.getFirstWord());
        newWordRelation.setSecondWord(newWordRelationRequest.getSecondWord());
        newWordRelation.setRelation(newWordRelationRequest.getRelation());
        return newWordRelation;
    }

    private WordRelation buildInverseRelation(WordRelation wordRelation) {
        WordRelation inverseRelation = new WordRelation();
        inverseRelation.setFirstWord(wordRelation.getSecondWord());
        inverseRelation.setSecondWord(wordRelation.getFirstWord());
        inverseRelation.setRelation(wordRelation.getRelation());

        return inverseRelation;
    }
}
