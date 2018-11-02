package com.services.impl;

import com.dao.RoleDao;
import com.dao.UserDao;
import com.dto.MyUserDetail;
import com.pojo.Role;
import com.pojo.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author：linma
 * @date: 2018/10/31 13:54
 * @email: linma@homeinns.com
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("当前用户不存在！");
        }
        Set<String> roles = getRolesByUsername(username);
        return new MyUserDetail(user, roles);
    }

    /**
     * 获取当前用户所有的角色信息
     *
     * @param username
     * @return
     */
    private Set<String> getRolesByUsername(String username) {
        Set<Role> roles  = roleDao.findRolesByUsername(username);
        Set<String> roleNames = null;
        if (roles.size() >= 0) {
            roleNames = roles.stream().map(Role::getRoleName).collect(Collectors.toSet());
        }
        return roleNames;
    }
}
