package com.rddesign.countonrd.controller;

import com.rddesign.countonrd.entity.User;
import com.rddesign.countonrd.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dova
 */
@RestController
public class UserController {

	@Autowired private UserService userService;
 
	@PostMapping("/users")
    public User saveUser(
        @RequestBody User user)
    {
        return userService.saveUser(user);
    }
	@GetMapping("/users")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }
 
    // Update operation
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,
                     @PathVariable("id") Long userId)
    {
        return userService.updateUser(
            user, userId);
    }
 
    // Delete operation
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id")
                                       Long userId)
    {
        userService.deleteUser(
            userId);
        return "Deleted Successfully";
    }
}
