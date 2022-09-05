package com.example.myownbackend.service;

import com.example.myownbackend.model.Tag;
import com.example.myownbackend.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> findTags() {
        return tagRepository.findAll();
    }
}
