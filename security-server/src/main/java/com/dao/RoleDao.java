package com.dao;

import com.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author：linma
 * @date: 2018/11/1 17:43
 * @email: linma@homeinns.com
 **/
@Repository
public interface RoleDao {

    /**
     * 根据用户账户，查询用户的权限
     *
     * @param username
     * @return
     */
    Set<Role> findRolesByUsername(String username);

}
