package com.boot.auth.example.custom;

import com.boot.auth.starter.exception.AuthException;
import com.boot.auth.starter.service.impl.DefaultOutJsonServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Primary
@Service
public class OutJsonServiceImpl extends DefaultOutJsonServiceImpl {
    final
    ObjectMapper objectMapper;

    public OutJsonServiceImpl(ObjectMapper objectMapper) {
        super(objectMapper);
        this.objectMapper = objectMapper;
    }

    @Override
    public String errorOutJson(String msg, String code) {
        //todo 在这里自己定义被权限拦截后的数据返回格式
        try {
            return objectMapper.writeValueAsString(msg);
        } catch (Exception e) {
            throw new AuthException(e);
        }
    }
}
