package com.example.DDDProject.domain.repository;


import com.example.DDDProject.domain.model.User;

import java.util.Optional;
import java.util.List;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    User save(User user);
    void delete(User user);
}
