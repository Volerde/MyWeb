package com.volerde.myweb.service;

import com.volerde.myweb.dao.UserRepository;
import com.volerde.myweb.pojo.User;
import com.volerde.myweb.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 *
 * @author Volerde
 * @date 2021 /8/16 19:36
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
