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
@TableName("task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务ID
     */
    @TableId
    private Long id;
    /**
     * 任务分类ID
     */
    @TableField("category_id")
    private Long categoryId;
    /**
     * 任务发布雇主ID
     */
    @TableField("employer_id")
    private Long employerId;
    /**
     * 任务标题
     */
    @TableField("task_title")
    private String taskTitle;
    /**
     * 任务简介
     */
    @TableField("task_profile")
    private String taskProfile;
    /**
     * 任务描述
     */
    @TableField("task_desc")
    private String taskDesc;
    /**
     * 最低预算价格
     */
    @TableField("fees_low")
    private Double feesLow;
    /**
     * 最高预算价格
     */
    @TableField("fees_high")
    private Double feesHigh;
    /**
     * 任务附件地址
     */
    @TableField("fees_file")
    private String feesFile;
    /**
     * 附件文件名称
     */
    @TableField("filename")
    private String filename;
    /**
     * 完成任务雇员ID
     */
    @TableField("employee_id")
    private Long employeeId;
    /**
     * 任务成交价格
     */
    @TableField("task_price")
    private Double taskPrice;
    /**
     * 任务状态
     */
    @TableField("task_status")
    private Byte taskStatus;
    /**
     * 成交时间
     */
    @TableField("close_time")
    private Date closeTime;
    /**
     * 中标时间
     */
    @TableField("bid_time")
    private Date bidTime;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
}
