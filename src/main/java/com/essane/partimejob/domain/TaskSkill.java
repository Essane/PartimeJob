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
@TableName("task_skill")
public class TaskSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务技能ID
     */
    @TableId
    private Long id;
    /**
     * 技能名称
     */
    @TableField("skill_name")
    private String skillName;
    /**
     * 任务ID
     */
    @TableField("task_id")
    private Long taskId;
}
