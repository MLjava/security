package com.dao;

import com.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author：linma
 * @date: 2018/10/31 13:30
 * @email: linma@homeinns.com
 **/
public class UserDaoTest extends SecurityApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void findUserByUsername() {
        System.out.println(userDao.findUserByUsername("superadmin"));
    }
}