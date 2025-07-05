package com.example.DDDProject.application;


import com.example.DDDProject.domain.model.User;

public interface IUserService {
    User getUserById(Long id);
    User getUserByUsername(String username);
    User createUser(String username, String password);
    User updateUser(Long id, String username, String password);
    User deleteUser(Long id);
}
