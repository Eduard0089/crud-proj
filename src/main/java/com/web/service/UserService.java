package com.web.service;



import com.web.repository.UserRepository;
import com.web.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    public List<User> getAllUsers()         { return repo.findAll(); }
    public User getUserById(Long id)         { return repo.findById(id).orElseThrow(); }
    public User saveOrUpdate(User user)         { return repo.save(user); }
    public void delete(Long id)      { repo.deleteById(id); }
}