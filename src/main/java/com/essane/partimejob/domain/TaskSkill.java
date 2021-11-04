package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "task_skill")
public class TaskSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务技能ID
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 技能名称
     */
    @Column(name = "skill_name")
    private String skillName;
    /**
     * 任务ID
     */
    @Column(name = "task_id")
    private Long taskId;
}
