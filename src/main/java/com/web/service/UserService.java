package com.web.service;



import com.web.repository.UserRepository;
import com.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}