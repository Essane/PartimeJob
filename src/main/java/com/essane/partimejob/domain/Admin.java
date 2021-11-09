package com.essane.partimejob.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Essane
 */
@Data
@TableName("admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员ID
     */
    @TableId
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
