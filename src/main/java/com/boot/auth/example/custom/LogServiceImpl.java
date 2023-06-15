package com.boot.auth.example.custom;

import com.boot.auth.starter.model.OperLogAnnotationEntity;
import com.boot.auth.starter.service.impl.DefaultLogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 自定义业务log拦截数据处理方案
 */
@Slf4j
@Primary
@Component
public class LogServiceImpl extends DefaultLogServiceImpl {
    @Override
    public void addLog(OperLogAnnotationEntity logEntity) {
        log.info("add log :{}", logEntity);
        //todo 在这里自己定义访问日志处理的方式
    }
}
