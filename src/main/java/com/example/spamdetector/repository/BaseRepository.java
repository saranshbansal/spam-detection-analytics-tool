package com.example.spamdetector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spamdetector.model.SpamDetector;

@Repository
public interface BaseRepository extends JpaRepository<SpamDetector, Long> {

}
