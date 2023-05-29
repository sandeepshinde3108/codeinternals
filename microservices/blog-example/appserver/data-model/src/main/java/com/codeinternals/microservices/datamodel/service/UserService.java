package com.codeinternals.microservices.datamodel.service;

import com.codeinternals.microservices.datamodel.entity.User;
import com.codeinternals.microservices.datamodel.entity.UserLogin;

public interface UserService {
    User registerUser(User user);
    User login(String username, String password);
    UserLogin loginAttempt(UserLogin userLogin);
}
