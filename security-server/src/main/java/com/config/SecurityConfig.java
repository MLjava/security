package com.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.security.AjaxAuthFailHandler;
import com.security.AjaxAuthSuccessHandler;
import com.security.LoginAuthenticationFilter;
import com.security.UnauthorizedEntryPoint;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Properties;

/**
 * @author：linma
 * @date: 2018/10/31 13:41
 * @email: linma@homeinns.com
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
     * 添加验证码
     *
     * @return
     */
    @Bean
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha captchaProducer = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "red");
        properties.setProperty("kaptcha.image.width", "125");
        properties.setProperty("kaptcha.image.height", "45");
        properties.setProperty("kaptcha.textproducer.font.size", "45");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http
                // 自定义匿名操作
                .exceptionHandling()
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                // 添加自定义拦截器，放在用户密码判断之前，实现验证码功能
                .addFilterBefore(new LoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                // 不拦截的页面
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/lib/**", "/homeinns/randcode")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                //表单登录
                .formLogin()
                .loginPage("/homeinns/login")
                // 添加自定义成功
                .successHandler(new AjaxAuthSuccessHandler())
                // 添加自定义失败
                .failureHandler(new AjaxAuthFailHandler())
                .defaultSuccessUrl("/homeinns/index", true)
                .loginProcessingUrl("/login")
                .and()
                .logout()
                // 实现登出操作
//                .logoutUrl("/homeinns/logout")
                .logoutSuccessUrl("/homeinns/login")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}