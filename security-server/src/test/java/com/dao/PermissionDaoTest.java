package com.dao;

import com.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author：linma
 * @date: 2018/11/1 18:19
 * @email: linma@homeinns.com
 **/
public class PermissionDaoTest extends SecurityApplicationTests {

    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void findPermissionsByUsername() {
        System.out.println(permissionDao.findPermissionsByUsername("admin"));
    }
}