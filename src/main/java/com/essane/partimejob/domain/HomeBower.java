package com.essane.partimejob.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Essane
 */
@Data
@TableName("home_bower")
public class HomeBower implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主页浏览表
     */
    @TableId
    private Long id;
    /**
     * 雇员ID
     */
    @TableField("employee_id")
    private Long employeeId;
    /**
     * 雇主ID
     */
    @TableField("employer_id")
    private Long employerId;
    /**
     * 浏览时间
     */
    @TableField("create_time")
    private Date createTime;
}
