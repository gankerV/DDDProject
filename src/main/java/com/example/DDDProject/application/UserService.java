package com.example.DDDProject.application;

import com.example.DDDProject.domain.model.User;
import com.example.DDDProject.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public User createUser(String username, String password) {
        if (userRepo.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("User exists: " + username);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long id, String username, String password) {
        User user = userRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User ID not found: " + id));

        user.setUsername(username);
        user.setPassword(password);
        return userRepo.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User ID not found: " + id));

        userRepo.delete(user);
        return user;
    }
}
