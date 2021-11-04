package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "task")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务ID
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 任务分类ID
     */
    @Column(name = "category_id")
    private Long categoryId;
    /**
     * 任务发布雇主ID
     */
    @Column(name = "employer_id")
    private Long employerId;
    /**
     * 任务标题
     */
    @Column(name = "task_title")
    private String taskTitle;
    /**
     * 任务简介
     */
    @Column(name = "task_profile")
    private String taskProfile;
    /**
     * 任务描述
     */
    @Column(name = "task_desc")
    private String taskDesc;
    /**
     * 最低预算价格
     */
    @Column(name = "fees_low")
    private Double feesLow;
    /**
     * 最高预算价格
     */
    @Column(name = "fees_high")
    private Double feesHigh;
    /**
     * 任务附件地址
     */
    @Column(name = "fees_file")
    private String feesFile;
    /**
     * 附件文件名称
     */
    @Column(name = "filename")
    private String filename;
    /**
     * 完成任务雇员ID
     */
    @Column(name = "employee_id")
    private Long employeeId;
    /**
     * 任务成交价格
     */
    @Column(name = "task_price")
    private Double taskPrice;
    /**
     * 任务状态
     */
    @Column(name = "task_status")
    private Byte taskStatus;
    /**
     * 成交时间
     */
    @Column(name = "close_time")
    private Date closeTime;
    /**
     * 中标时间
     */
    @Column(name = "bid_time")
    private Date bidTime;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
