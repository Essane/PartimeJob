package com.essane.partimejob.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "task_category")
public class TaskCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务分类ID
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;
    /**
     * 分类图片展示地址
     */
    @Column(name = "category_img")
    private String categoryImg;
    /**
     * 是否热门 0 否 1 热门
     */
    @Column(name = "is_popular")
    private Byte isPopular;
}
