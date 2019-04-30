package com.example.simple_maven_app.service.impl;

import com.example.simple_maven_app.entity.User;
import com.example.simple_maven_app.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserById() {
        User user = userService.findUserById(1);
        assertNotNull(user);
        assertEquals("1418377085@qq.com",user.getEmail());
        assertEquals("1418377085",user.getName());
    }

    @Test
    public void findUserByEmail() {
        User user = userService.findUserByEmail("1418377085@qq.com");
        assertNotNull(user);
        assertEquals(1, (long) user.getId());
        assertEquals("1418377085",user.getName());
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void createUser() {
    }
}