package com.example.myownbackend.model.mapper;

import com.example.myownbackend.model.Concept;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class ConceptToIDMapper {

    @Named("conceptToID")
    public Long mapConceptToID(Concept concept) {
        return concept.getId();
    }
}
