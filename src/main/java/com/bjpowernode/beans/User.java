package com.bjpowernode.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户类
 *
 * @author Dee
 * @date 2023-03-07 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 用户id
     */
    private String id;
    /**
     * 所属部门id
     */
    private String depId;
    /**
     * 登录账号
     */
    private String loginAct;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 用户密码
     */
    private String loginPwd;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 账号失效时间
     */
    private String expireTime;
    /**
     * 账号是否锁定，0表示锁定，1表示启用
     */
    private Integer lockStatus;
    /**
     * 允许登录IP
     */
    private String allowIps;
    /**
     * 用户信息添加人
     */
    private String createById;
    private User createBy;
    /**
     * 用户信息添加时间
     */
    private String createTime;
    /**
     * 用户信息修改人
     */
    private String editById;
    private User editBy;
    /**
     * 用户信息修改时间
     */
    private String editTime;
}
