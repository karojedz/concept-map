package com.example.myownbackend.repository;

import com.example.myownbackend.model.Concept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConceptRepository extends JpaRepository<Concept, Long> {

    @Query("SELECT MAX(c.id) FROM Concept c")
    Long findMaxId();
}
