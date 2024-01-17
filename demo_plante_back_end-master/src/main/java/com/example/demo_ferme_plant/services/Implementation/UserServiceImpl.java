package com.example.demo_ferme_plant.services.Implementation;

import com.example.demo_ferme_plant.entities.User;
import com.example.demo_ferme_plant.repository.UserRepository;
import com.example.demo_ferme_plant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
    User existUser = userRepository.getById(userId);
existUser.setEmail(updatedUser.getEmail());
existUser.setPassword(updatedUser.getPassword());
existUser.setRole(updatedUser.getRole());
existUser.setImage(updatedUser.getImage());
existUser.setNom(updatedUser.getNom());
existUser.setPrenom(updatedUser.getPrenom());
   return  userRepository.save(existUser);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
