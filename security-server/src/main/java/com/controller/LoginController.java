package com.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author：linma
 * @date: 2018/10/31 14:13
 * @email: linma@homeinns.com
 **/
@Controller
@RequestMapping("/homeinns")
@Slf4j
public class LoginController {

    public static final String LOGIN = "login";

    public static final String INDEX = "index";

    @Autowired
    private DefaultKaptcha captchaProducer;

    @GetMapping("/login")
    public String login() {
        return LOGIN;
    }

    @GetMapping("/index")
    public String index() {
        return INDEX;
    }

    /**
     * 请求的验证码
     *
     */
    @GetMapping("/randcode")
    public void randCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // 设置返回文件类型
        response.setContentType("image/jpeg");

        // 获取验证码上的文字
        String capText = captchaProducer.createText();

        // 将验证码上的文字保存在session中
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        log.info("验证码为:" + code);

        //  将文件渲染到图片上
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpeg", out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
