package com.dao;

import com.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author：linma
 * @date: 2018/11/1 17:47
 * @email: linma@homeinns.com
 **/
@Repository
public interface PermissionDao {

    /**
     *
     * 根据用户账户，查询信息
     *
     * @param username
     * @return
     */
    Set<Permission> findPermissionsByUsername(String username);
}
