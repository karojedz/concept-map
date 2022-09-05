package com.example.myownbackend.service;

import com.example.myownbackend.model.dto.ConceptDto;
import com.example.myownbackend.model.mapper.ConceptMapper;
import com.example.myownbackend.repository.ConceptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.example.myownbackend.model.Concept;

@RequiredArgsConstructor
@Service
public class ConceptService {

    private final ConceptRepository conceptRepository;
    private final ConceptMapper conceptMapper;

    public List<ConceptDto> findConcepts() {
        List<Concept> concepts = conceptRepository.findAll();
        return conceptMapper.mapConceptList(concepts);
    }

    public ConceptDto findConcept(Long id) {
        Optional<Concept> maybeConcept = conceptRepository.findById(id);
        if (maybeConcept.isPresent()) {
            Concept concept = maybeConcept.get();
            return conceptMapper.mapConceptToDto(concept);
        } else {
            return null;
        }
    }

    public ConceptDto findRandomConcept() {
        Long max = conceptRepository.findMaxId();
        Random random = new Random();
        Long randomId = Math.abs(random.nextLong()) % max + 1;
        Optional<Concept> randomConcept = conceptRepository.findById(randomId);
        if (randomConcept.isPresent()) {
            Concept concept = randomConcept.get();
            return conceptMapper.mapConceptToDto(concept);
        } else {
            return null;
        }
    }
}
