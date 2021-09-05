package com.volerde.myweb.service;

import com.volerde.myweb.pojo.User;

/**
 * The interface User service.
 *
 * @author Volerde
 * @date 2021 /8/16 19:34
 */
public interface UserService {

    /**
     * 检查用户
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link User}
     */
    User checkUser(String username, String password);
}
