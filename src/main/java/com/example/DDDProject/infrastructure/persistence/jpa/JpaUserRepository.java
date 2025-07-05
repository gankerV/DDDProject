package com.example.DDDProject.infrastructure.persistence.jpa;

import com.example.DDDProject.domain.model.User;
import com.example.DDDProject.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository  // báo cho Spring biết đây là bean được tiêm vào
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserJpaRepo jpaRepo;

    public JpaUserRepository(SpringDataUserJpaRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaRepo.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public User save(User user) {
        return jpaRepo.save(user);
    }

    @Override
    public void delete(User user) {
        jpaRepo.delete(user);
    }
}
