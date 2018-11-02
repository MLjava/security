package com.config;

import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author：linma
 * @date: 2018/10/31 13:41
 * @email: linma@homeinns.com
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置数据校验和密码加密
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 配置访问页面配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        // 开始配置页面
        http
                .authorizeRequests()
                // 静态资源被忽略
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/lib/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/homeinns/login")
                .defaultSuccessUrl("/homeinns/index")
                .and()
                .logout()
                .logoutSuccessUrl("/homeinns/login")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}