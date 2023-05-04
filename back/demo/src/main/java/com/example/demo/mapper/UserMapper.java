package com.example.demo.mapper;

import com.example.demo.model.User;
import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    User getUserById(Long id);
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}