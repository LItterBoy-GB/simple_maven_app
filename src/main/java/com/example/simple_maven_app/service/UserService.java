package com.example.simple_maven_app.service;


import com.example.simple_maven_app.entity.User;

/**
 * @author 14183
 */
public interface UserService {

    public User findUserById(long id);

    public User findUserByEmail(String email);

    public User saveUser(User user);

    public User createUser(User user);
}
