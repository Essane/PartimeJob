package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "employer")
public class Employer implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 雇主ID
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 登录密码
     */
    @Column(name = "`password`")
    private String password;
    /**
     * 头像
     */
    @Column(name = "head_img")
    private String headImg;
    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
