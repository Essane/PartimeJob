package com.essane.partimejob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.essane.partimejob.domain.TaskCategory;
import com.essane.partimejob.vo.TaskCategoryVo;

import java.util.List;

/**
 * 任务分类业务逻辑接口
 *
 * @author Essane
 */
public interface TaskCategoryService extends IService<TaskCategory> {

    /**
     * 查询所有任务分类
     *
     * @return
     */
    List<TaskCategoryVo> getAll();

    /**
     * 保存任务分类
     * @param taskCategory
     */
    void saveTaskCategory(TaskCategory taskCategory);

    /**
     * 设为热门
     *
     * @param id
     */
    void onPopular(Long id);

    /**
     * 解除热门
     *
     * @param id
     */
    void closePopular(Long id);

    /**
     * 查询热门分类
     *
     * @return
     */
    List<TaskCategoryVo> getPopular();

}




