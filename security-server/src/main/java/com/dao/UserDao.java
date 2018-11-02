package com.dao;

import com.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author：linma
 * @date: 2018/10/31 12:37
 * @email: linma@homeinns.com
 **/
@Repository
public interface UserDao {

    /**
     * 根据用户账号，查询用户信息
     *
     * @param username 用户账号
     * @return
     */
    User findUserByUsername(String username);
}
