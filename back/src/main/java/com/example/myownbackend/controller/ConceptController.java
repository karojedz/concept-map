package com.example.myownbackend.controller;

import com.example.myownbackend.model.dto.ConceptDto;
import com.example.myownbackend.service.ConceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ConceptController {

    private final ConceptService conceptService;

    @GetMapping("/concepts")
    List<ConceptDto> getConcepts() {
        return conceptService.findConcepts();
    }

    @GetMapping("/concepts/{id}")
    ConceptDto getConcept(@PathVariable Long id) {
        return conceptService.findConcept(id);
    }

    @GetMapping("/concepts/random")
    ConceptDto getRandomConcept() {
        return conceptService.findRandomConcept();
    }
}
