package com.essane.partimejob.vo;

import com.essane.partimejob.domain.Employer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 雇员主页浏览视图展示对象
 *
 * @author by Essane
 * @Classname HomeBowerVo
 * @Date 2019/10/15 8:40
 * @see com.essane.partimejob.vo
 */
@Data
public class HomeBowerVo implements Serializable {

    /**
     * 主页浏览表
     */
    private Long id;

    /**
     * 雇主信息
     */
    private Employer employer;

    /**
     * 浏览时间
     */
    private Date createTime;
}
