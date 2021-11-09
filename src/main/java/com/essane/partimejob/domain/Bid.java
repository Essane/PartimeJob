package com.essane.partimejob.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("bid")
public class Bid implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 投标ID
     */
    @TableId
    private Long id;
    /**
     * 任务ID
     */
    @TableField("task_id")
    private Long taskId;
    /**
     * 职业者ID
     */
    @TableField("employee_id")
    private Long employeeId;
    /**
     * 投标价格
     */
    @TableField("bid_price")
    private Double bidPrice;
    /**
     * 交货时间描述，例如 1 天
     */
    @TableField("delivery_desc")
    private String deliveryDesc;
    /**
     * 交货时间
     */
    @TableField("delivery_time")
    private Date deliveryTime;
    /**
     * 竞标状态
     */
    @TableField("bid_status")
    private Byte bidStatus;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
}
