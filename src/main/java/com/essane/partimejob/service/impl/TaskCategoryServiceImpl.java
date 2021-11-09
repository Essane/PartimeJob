package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.consts.TaskCategoryStatus;
import com.essane.partimejob.consts.TaskStatus;
import com.essane.partimejob.domain.Task;
import com.essane.partimejob.domain.TaskCategory;
import com.essane.partimejob.mapper.TaskCategoryMapper;
import com.essane.partimejob.mapper.TaskMapper;
import com.essane.partimejob.service.TaskCategoryService;
import com.essane.partimejob.service.TaskService;
import com.essane.partimejob.utils.IDUtil;
import com.essane.partimejob.vo.TaskCategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 任务分类业务逻辑实现
 *
 * @author Essane
 */
@Service
public class TaskCategoryServiceImpl extends ServiceImpl<TaskCategoryMapper, TaskCategory> implements TaskCategoryService {

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskService taskService;

    @Override
    public List<TaskCategoryVo> getAll() {
        // 查询所有
        List<TaskCategory> taskCategories = list();
        // 将所有的 TaskCategory 转换为 TaskCategoryVo 页面展示对象
        return taskCategoriesToTaskCategoryVos(taskCategories);
    }


    @Override
    public void saveTaskCategory(TaskCategory taskCategory) {
        // 如果 id 不为空，则为修改任务分类
        if (taskCategory.getId() != null) {
            // 根据主键选择性添加分类，有值的就修改，为 null 不修改
            saveOrUpdate(taskCategory);
        } else {
            // id 为空，新增任务分类
            // 生成随机ID
            taskCategory.setId(IDUtil.getRandomId());
            // 设置是否热门，默认不热门（0）
            taskCategory.setIsPopular(TaskCategoryStatus.NO_POPULAR);
            // 插入到数据库
            save(taskCategory);
        }
    }

    @Override
    public void onPopular(Long id) {
        // 根据 ID 查询出任务分类信息
        TaskCategory taskCategory = getById(id);
        // 设置为热门
        taskCategory.setIsPopular(TaskCategoryStatus.POPULAR);
        // 更新任务分类信息
        updateById(taskCategory);
    }

    @Override
    public void closePopular(Long id) {
        // 根据 ID 查询出任务分类信息
        TaskCategory taskCategory = getById(id);
        // 解除热门
        taskCategory.setIsPopular(TaskCategoryStatus.NO_POPULAR);
        // 更新任务分类信息
        updateById(taskCategory);
    }


    @Override
    public List<TaskCategoryVo> getPopular() {
        // 构建查询条件
        QueryWrapper<TaskCategory> queryWrapper = new QueryWrapper<>();
        // 分类状态为 1 为热门分类
        queryWrapper.eq("is_popular", TaskCategoryStatus.POPULAR);
        // 执行查询
        List<TaskCategory> tasks = list(queryWrapper);
        // 将查询到的任务分类信息转换为 Vo 对象，因为页面展示需要分类数量
        return taskCategoriesToTaskCategoryVos(tasks);
    }

    /**
     * 将所有的 TaskCategory 转换为 TaskCategoryVo 页面展示对象
     *
     * @param taskCategories
     * @return
     */
    private List<TaskCategoryVo> taskCategoriesToTaskCategoryVos(List<TaskCategory> taskCategories) {
        // 将所有的 TaskCategory 转换为 TaskCategoryVo 页面展示对象
        List<TaskCategoryVo> taskCategoryVos = new ArrayList<>();
        for (TaskCategory taskCategory : taskCategories) {
            TaskCategoryVo taskCategoryVo = new TaskCategoryVo();
            BeanUtils.copyProperties(taskCategory, taskCategoryVo);
            // 查询分类总任务数量
            QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("category_id", taskCategoryVo.getId())
                    .ne("task_status", TaskStatus.CHECK_FAIL)
                    .ne("task_status", TaskStatus.UNCHECK)
                    .ne("task_status", TaskStatus.COMPLETE);
            List<Task> tasks = taskMapper.selectList(queryWrapper);
            Integer taskCount = tasks != null ? tasks.size() : 0;
            taskCategoryVo.setTaskCount(taskCount);
            // 添加到集合
            taskCategoryVos.add(taskCategoryVo);
        }
        return taskCategoryVos;
    }
}




