package com.backend.Quora.Services;

import com.backend.Quora.models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {


    User save(User user);
    List<User> findAll();
    Optional<User> findById(UUID userId);
    void deleteUser(UUID userId);

}
