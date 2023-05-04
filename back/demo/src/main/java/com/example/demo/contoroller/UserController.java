package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
      this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
      return userService.getUsers();
  }

  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable Long id) {
      return userService.getUserById(id);
  }

  @PostMapping("/users")
  public void createUser(@RequestBody User user) {
      userService.createUser(user);
  }

  @PutMapping("/users/{id}")
  public void updateUser(@PathVariable Long id, @RequestBody User user) {
      userService.updateUser(id, user);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Long id) {
      userService.deleteUser(id);
  }
}
