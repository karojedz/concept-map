package com.example.myownbackend.model.mapper;

import com.example.myownbackend.model.Concept;
import com.example.myownbackend.model.Tag;
import com.example.myownbackend.model.dto.ConceptDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-01T20:45:31+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ConceptMapperImpl extends ConceptMapper {

    @Autowired
    private ConceptToIDMapper conceptToIDMapper;

    @Override
    public ConceptDto mapConceptToDto(Concept concept) {
        if ( concept == null ) {
            return null;
        }

        ConceptDto conceptDto = new ConceptDto();

        conceptDto.setPrevious( conceptListToIntegerList( concept.getPrevious() ) );
        conceptDto.setId( concept.getId() );
        conceptDto.setTitle( concept.getTitle() );
        conceptDto.setText( concept.getText() );
        List<Tag> list1 = concept.getTags();
        if ( list1 != null ) {
            conceptDto.setTags( new ArrayList<Tag>( list1 ) );
        }

        return conceptDto;
    }

    @Override
    public List<ConceptDto> mapConceptList(List<Concept> concepts) {
        if ( concepts == null ) {
            return null;
        }

        List<ConceptDto> list = new ArrayList<ConceptDto>( concepts.size() );
        for ( Concept concept : concepts ) {
            list.add( mapConceptToDto( concept ) );
        }

        return list;
    }

    protected List<Integer> conceptListToIntegerList(List<Concept> list) {
        if ( list == null ) {
            return null;
        }

        List<Integer> list1 = new ArrayList<Integer>( list.size() );
        for ( Concept concept : list ) {
            list1.add( conceptToIDMapper.mapConceptToID( concept ).intValue() );
        }

        return list1;
    }
}
