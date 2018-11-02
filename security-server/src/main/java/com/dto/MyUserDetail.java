package com.dto;

import com.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author：linma
 * @date: 2018/10/31 12:35
 * @email: linma@homeinns.com
 **/
public class MyUserDetail implements UserDetails {

    private User user;

    private Set<String> roles;

    public MyUserDetail(User user, Set<String> roles) {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority :: new).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 鉴定用户锁住状态
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return user.getLock().equals(0) ? true : false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 鉴定用户可用状态
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return user.getFlag().equals(0) ? true : false;
    }
}
