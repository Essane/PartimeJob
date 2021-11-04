package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "employee_bookmarked")
public class EmployeeBookmarked implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 雇员收藏任务ID
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
     * 任务ID
     */
    @Column(name = "task_id")
    private Long taskId;
}
