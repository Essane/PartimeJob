package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "employee_skill")
public class EmployeeSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 雇员技能对应ID
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 雇员ID
     */
    @Column(name = "employee_id")
    private Long employeeId;
    /**
     * 技能名称
     */
    @Column(name = "skill_name")
    private String skillName;
}
