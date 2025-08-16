package com.example.DDDProject.domain.repositories;

import com.example.DDDProject.domain.entities.User;
import java.util.Optional;
import java.util.List;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
}
