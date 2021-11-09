package com.essane.partimejob.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Essane
 */
@Data
@TableName("employee_bookmarked")
public class EmployeeBookmarked implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 雇员收藏任务ID
     */
    @TableId
    private Long id;
    /**
     * 雇员ID
     */
    @TableField("employee_id")
    private Long employeeId;
    /**
     * 任务ID
     */
    @TableField("task_id")
    private Long taskId;
}
