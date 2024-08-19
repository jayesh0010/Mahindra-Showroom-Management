package com.mahindrashowrooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahindrashowrooms.model.User;
import com.mahindrashowrooms.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   
    public void saveUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        userRepository.save(newUser);
    }

    
    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
