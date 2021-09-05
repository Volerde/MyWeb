package com.volerde.myweb.dao;

import com.volerde.myweb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User repository.
 *
 * @author Volerde
 * @date 2021 /8/16 19:38
 */
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 找到的用户名和密码
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link User}
     */
    User findByUsernameAndPassword(String username, String password);
}
