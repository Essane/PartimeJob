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
@TableName("task_category")
public class TaskCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 任务分类ID
     */
    @TableId
    private Long id;
    /**
     * 分类名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 分类图片展示地址
     */
    @TableField("category_img")
    private String categoryImg;
    /**
     * 是否热门 0 否 1 热门
     */
    @TableField("is_popular")
    private Byte isPopular;
}
