package com.boot.auth.example.common;

import com.boot.auth.example.custom.RolesConstant;
import com.boot.auth.starter.common.AuthConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liucheng
 * @version 1.0
 * @description: 账户
 * @date 2023/6/5 17:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户组
     */
    private String group;
    /**
     * 用户编号
     */
    private String userNo;
    /**
     * 用户权限
     */
    private String roles;

    /**
     * 获取一个默认的用户
     */
    public static Account findAccount() {
        return new Account("我是用户昵称", "我是group", "U123456",
                String.join(AuthConstant.HEAD_TOKEN_SEPARATOR, RolesConstant.USER_1, RolesConstant.DEFAULT));
    }
}
