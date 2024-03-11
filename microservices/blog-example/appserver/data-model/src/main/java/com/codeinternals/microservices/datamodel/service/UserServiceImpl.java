package com.codeinternals.microservices.datamodel.service;

import com.codeinternals.microservices.datamodel.entity.User;
import com.codeinternals.microservices.datamodel.entity.UserLogin;
import com.codeinternals.microservices.datamodel.repository.UserLoginRepository;
import com.codeinternals.microservices.datamodel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;


    @Override
    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public UserLogin loginAttempt(UserLogin userLogin) {
        return null;
    }
}
