package com.boot.auth.example.controllers;

import com.boot.auth.example.custom.RolesConstant;
import com.boot.auth.starter.common.AuthConstant;
import com.boot.auth.starter.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthService authService;

    @GetMapping("/")
    public String login(HttpServletResponse response,
                        HttpServletRequest request) throws Exception {
        log.info("访问到了 login");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(AuthConstant.SESSION_NICK_NAME, "我是用户昵称");
        String group = "";
        String userNo = "123456";
        String roles = String.join(AuthConstant.HEAD_TOKEN_SEPARATOR, RolesConstant.USER_1, RolesConstant.DEFAULT);
        return authService.auth(group, userNo, roles, parameters, response, request);
    }
}
