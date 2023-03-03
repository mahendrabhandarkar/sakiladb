package com.sakila.sakilaproject.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sakila.sakilaproject.entity.Attempts;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Integer> {
    Optional<Attempts> findAttemptsByUsername(String username);
}