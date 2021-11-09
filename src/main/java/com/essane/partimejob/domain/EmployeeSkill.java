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
@TableName("employee_skill")
public class EmployeeSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 雇员技能对应ID
     */
    @TableId
    private Long id;
    /**
     * 雇员ID
     */
    @TableField("employee_id")
    private Long employeeId;
    /**
     * 技能名称
     */
    @TableField("skill_name")
    private String skillName;
}
