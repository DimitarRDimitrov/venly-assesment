package io.localhost.wordrelations.controller;

import io.localhost.wordrelations.model.WordRelation;
import io.localhost.wordrelations.model.WordRelationRequest;
import io.localhost.wordrelations.service.WordRelationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/word-relations")
public class WordRelationsController {


    private final WordRelationService wordRelationService;

    public WordRelationsController(WordRelationService wordRelationService) {
        this.wordRelationService = wordRelationService;
    }

    @PostMapping
    public Long createRelation(@Valid @RequestBody WordRelationRequest request) {
        return wordRelationService.createWordRelation(request);
    }

    @GetMapping
    public List<WordRelation> getAllWordRelations(@RequestParam(required = false, name = "relation")
                                                  String relationFilter) {
        return wordRelationService.getAllWordRelations(relationFilter);
    }
}
