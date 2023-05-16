package io.localhost.wordrelations.service;

import io.localhost.wordrelations.model.WordRelation;
import io.localhost.wordrelations.model.WordRelationRequest;
import io.localhost.wordrelations.repository.WordRelationRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordRelationService {

    private final WordRelationRepository wordRelationRepository;


    public WordRelationService(WordRelationRepository wordRelationRepository) {
        this.wordRelationRepository = wordRelationRepository;
    }

    public List<WordRelation> getAllWordRelations(String relationFilter) {
        if (Strings.isBlank(relationFilter)) {
            return wordRelationRepository.findAll();
        }

        return wordRelationRepository.findByRelation(relationFilter);
    }

    public Long createWordRelation(WordRelationRequest newWordRelationRequest) {
        WordRelation newWordRelation = buildWorldRelationFromRequest(newWordRelationRequest);

        return wordRelationRepository.save(newWordRelation).getId();
    }

    private WordRelation buildWorldRelationFromRequest(WordRelationRequest newWordRelationRequest) {
        WordRelation newWordRelation = new WordRelation();
        newWordRelation.setFirstWord(newWordRelationRequest.getFirstWord());
        newWordRelation.setSecondWord(newWordRelationRequest.getSecondWord());
        newWordRelation.setRelation(newWordRelationRequest.getRelation());
        return newWordRelation;
    }
}
