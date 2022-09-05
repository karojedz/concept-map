package com.example.myownbackend.model.mapper;

import com.example.myownbackend.model.Concept;
import com.example.myownbackend.model.dto.ConceptDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ConceptToIDMapper.class)
public abstract class ConceptMapper {

    @Mapping(target = "previous", qualifiedByName = "conceptToID")
    public abstract ConceptDto mapConceptToDto(Concept concept);

    @Mapping(target = "previous", qualifiedByName = "conceptToID")
    public abstract List<ConceptDto> mapConceptList(List<Concept> concepts);
}
