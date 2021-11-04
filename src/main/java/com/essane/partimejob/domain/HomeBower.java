package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "home_bower")
public class HomeBower implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主页浏览表
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
     * 雇主ID
     */
    @Column(name = "employer_id")
    private Long employerId;
    /**
     * 浏览时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
