package com.example.myownbackend.repository;

import com.example.myownbackend.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT MAX(q.id) FROM Quote q")
    Long findMaxId();
}
