package com.example.myownbackend.service;

import com.example.myownbackend.model.Quote;
import com.example.myownbackend.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public List<Quote> findQuotes() {
        return quoteRepository.findAll();
    }

    public Quote findQuote(Long id) {
        Optional<Quote> maybeQuote = quoteRepository.findById(id);
        return maybeQuote.orElse(null);
    }

    public Quote findRandomQuote() {
        Long max = quoteRepository.findMaxId();
        Random random = new Random();
        Long randomId = Math.abs(random.nextLong()) % max +1;
        Optional<Quote> randomQuote = quoteRepository.findById(randomId);
        return randomQuote.orElse(null);
    }
}
