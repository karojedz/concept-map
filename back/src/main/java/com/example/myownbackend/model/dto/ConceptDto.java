package com.example.myownbackend.model.dto;

import com.example.myownbackend.model.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ConceptDto {

    private Long id;
    private String title;
    private String text;
    private List<Integer> previous = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();

}
