package com.example.myownbackend.controller;

import com.example.myownbackend.model.Quote;
import com.example.myownbackend.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping("/quotes")
    List<Quote> getQuotes() {
        return quoteService.findQuotes();
    }

    @GetMapping("/quotes/{id}")
    Quote getQuote(@PathVariable Long id) {
        return quoteService.findQuote(id);
    }

    @GetMapping("/quotes/random")
    Quote getRandomQuote() {
        return quoteService.findRandomQuote();
    }
}
