package com.example.demoproject.dao;

import com.example.demoproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    <S extends User> S save(S entity);

    @Override
    List<User> findAllById(Iterable<Integer> integers);
}
