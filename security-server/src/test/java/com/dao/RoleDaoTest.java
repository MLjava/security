package com.dao;

import com.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author：linma
 * @date: 2018/11/1 17:59
 * @email: linma@homeinns.com
 **/
public class RoleDaoTest extends SecurityApplicationTests {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void findRoleByUsername() {
        System.out.println(roleDao.findRolesByUsername("admin"));
    }
}