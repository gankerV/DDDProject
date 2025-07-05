package com.example.DDDProject.infrastructure.persistence.jpa;


import com.example.DDDProject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataUserJpaRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
