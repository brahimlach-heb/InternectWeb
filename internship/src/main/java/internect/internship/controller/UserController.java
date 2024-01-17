package internect.internship.controller;

import internect.internship.Models.User;

import internect.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.getUserById(id).isPresent()) {
            user.setId(id);
            User updatedUser = userService.saveUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/verify")
    public ResponseEntity<Object> verifyUser(@RequestBody User user) {
        // Check if the provided user information is valid
        if (user != null && user.getUsername() != null && user.getPassword() != null) {
            Optional<User> existingUser = userService.findByUsername(user.getUsername());

            if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
                // If the user is found and passwords match, return user ID
                return new ResponseEntity<>(existingUser.get().getId(), HttpStatus.OK);
            } else {
                // If the user is not found or passwords do not match, return false
                return new ResponseEntity<>(false, HttpStatus.OK);
            }
        } else {
            // Invalid user information provided
            return new ResponseEntity<>("Invalid user information", HttpStatus.BAD_REQUEST);
        }
    }
}

