package com.example.myownbackend.controller;

import com.example.myownbackend.model.Tag;
import com.example.myownbackend.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags")
    List<Tag> getTags() {
        return tagService.findTags();
    }
}
