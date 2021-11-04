package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "`admin`")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员ID
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
     * 密码
     */
    @Column(name = "`password`")
    private String password;
}
