package com.example.DDDProject.infrastructure.repositories.jpa;

import com.example.DDDProject.domain.entities.User;
import com.example.DDDProject.domain.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {
    @Override
    Optional<User> findByUsername(String username);

    @Override
    boolean existsByUsername(String username);
}
