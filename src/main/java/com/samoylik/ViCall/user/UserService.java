package com.samoylik.ViCall.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USER_LIST = new ArrayList<>();


    public void registerUser(User user) {
        user.setStatus("ACTIVE");
        USER_LIST.add(user);
    }

    public User login(User user) {
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
        var cUser = USER_LIST.get(userIndex);
        if (!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        cUser.setStatus("ACTIVE");
        return cUser;
    }

    public void logout(String email) {
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    USER_LIST.get(userIndex).setStatus("INACTIVE");
    }

    public List<User> findALL() {
        return USER_LIST;
    }
}
