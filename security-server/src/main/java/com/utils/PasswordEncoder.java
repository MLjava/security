package com.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author：linma
 * @date: 2018/10/31 15:37
 * @email: linma@homeinns.com
 **/
public class PasswordEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }
}
