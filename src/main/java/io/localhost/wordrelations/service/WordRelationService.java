package io.localhost.wordrelations.service;

import io.localhost.wordrelations.model.WordRelation;
import io.localhost.wordrelations.model.WordRelationRequest;
import io.localhost.wordrelations.repository.WordRelationRepository;
import org.springframework.stereotype.Service;

@Service
public class WordRelationService {

    private final WordRelationRepository wordRelationRepository;


    public WordRelationService(WordRelationRepository wordRelationRepository) {
        this.wordRelationRepository = wordRelationRepository;
    }

    public Long createWordRelation(WordRelationRequest newWordRelationRequest) {
        WordRelation newWordRelation = new WordRelation();
        newWordRelation.setFirstWord(newWordRelationRequest.getFirstWord());
        newWordRelation.setSecondWord(newWordRelationRequest.getSecondWord());
        newWordRelation.setRelation(newWordRelationRequest.getRelation());

        return wordRelationRepository.save(newWordRelation).getId();
    }
}
