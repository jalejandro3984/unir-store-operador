package com.unir.store_core.controller;

import com.unir.store_core.model.db.User;
import com.unir.store_core.model.dto.UserDto;
import com.unir.store_core.model.request.UserRequest;
import com.unir.store_core.repository.UserJpaRepository;
import com.unir.store_core.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {
    private final UserJpaRepository repository;
    private final UserService service;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest request) {
        User user = service.createUser(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = repository.findById(id).orElse(null);

        if (null == user) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto body) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        User updatedUser = service.updateUser(id, body);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = repository.findById(id).orElse(null);

        if (null == user) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(user);

        return ResponseEntity.noContent().build();
    }
}
