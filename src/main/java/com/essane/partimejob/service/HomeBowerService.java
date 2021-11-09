package com.essane.partimejob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.essane.partimejob.domain.HomeBower;
import com.essane.partimejob.vo.HomeBowerVo;

import java.util.List;

/**
 * 首页业务逻辑接口
 *
 * @author Essane
 */
public interface HomeBowerService extends IService<HomeBower> {

    /**
     * 获取雇员
     *
     * @param id
     * @return
     */
    List<HomeBowerVo> getByRecentlyEmployeeId(Long id);
}
