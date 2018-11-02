package com.controller;

import com.utils.ResultUtils;
import com.utils.ResultVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：linma
 * @date: 2018/11/2 10:32
 * @email: linma@homeinns.com
 **/
@RestController
@RequestMapping("/homeinns")
@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
public class DemoController {

    @GetMapping("/demo")
    public ResultVO demo() {
        return ResultUtils.success("Hello world!");
    }

}
