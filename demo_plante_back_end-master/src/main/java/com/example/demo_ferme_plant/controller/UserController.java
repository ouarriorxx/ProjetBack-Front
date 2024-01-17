package com.example.demo_ferme_plant.controller;

import com.example.demo_ferme_plant.entities.User;
import com.example.demo_ferme_plant.services.UserService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired

    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
           @Nullable @RequestParam("role") int role,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
             @Nullable @RequestParam("image") MultipartFile image) {


        // Your logic to save the user with image processing

        User newUser = new User();
        newUser.setNom(nom);
        newUser.setPrenom(prenom);
        newUser.setRole(role);
        newUser.setEmail(email);
        newUser.setPassword(password);
        // Set other user properties and process the image as needed

        User savedUser = userService.saveUser(newUser);

        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user=userService.updateUser(id,updatedUser);


            return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public String login(@RequestBody User admin) {
        User loggedInUser = userService.login(admin.getEmail(), admin.getPassword());
        if (loggedInUser != null) {
            if (loggedInUser.getRole()==1){
                return "admin";
            }else{
                return "user";
            }

        } else {
            return "Invalid";
        }
    }
}
