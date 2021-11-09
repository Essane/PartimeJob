package com.essane.partimejob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.essane.partimejob.domain.EmployeeBookmarked;
import com.essane.partimejob.vo.EmployeeBookmarkedVo;

import java.util.List;

/**
 * 雇员收藏业务逻辑接口
 * @author Essane
 */
public interface EmployeeBookmarkedService extends IService<EmployeeBookmarked> {


    /**
     * 雇员收藏任务
     *
     * @param id     雇员 ID
     * @param taskId 任务 ID
     * @return
     */
    EmployeeBookmarked bookmarked(Long id, Long taskId);

    /**
     * 获取雇员收藏任务集合
     *
     * @param employeeId 雇员 ID
     * @return
     */
    List<EmployeeBookmarkedVo> getByEmployeeId(Long employeeId);

    /**
     * 获取雇员任务 ID 集合
     *
     * @param employeeId 雇员 ID
     * @return
     */
    List<Long> getIdsByEmployeeId(Long employeeId);

    /**
     * 删除收藏信息
     *
     * @param id     雇员 ID
     * @param taskId 任务 ID
     */
    void remove(Long id, Long taskId);
}
