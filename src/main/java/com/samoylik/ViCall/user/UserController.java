package com.samoylik.ViCall.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping
    public void register(User user) {
        service.registerUser(user);
    }

    @PostMapping("/login")
    public User login(User user) {
        return service.login(user);
    }

    @PostMapping("/logout")
    public void logout(String email) {
        service.logout(email);
    }

    @GetMapping
    public List<User> findALL() {
        return service.findALL();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
