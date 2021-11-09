package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.domain.EmployeeBookmarked;
import com.essane.partimejob.mapper.EmployeeBookmarkedMapper;
import com.essane.partimejob.service.EmployeeBookmarkedService;
import com.essane.partimejob.service.TaskService;
import com.essane.partimejob.utils.IDUtil;
import com.essane.partimejob.vo.EmployeeBookmarkedVo;
import com.essane.partimejob.vo.TaskVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 雇员收藏业务逻辑接口实现
 *
 * @author Essane
 */
@Service
public class EmployeeBookmarkedServiceImpl extends ServiceImpl<EmployeeBookmarkedMapper, EmployeeBookmarked> implements EmployeeBookmarkedService {

    @Resource
    private EmployeeBookmarkedMapper employeeBookmarkedMapper;

    @Resource
    private TaskService taskService;

    @Override
    public EmployeeBookmarked bookmarked(Long id, Long taskId) {
        // 先根据雇员ID和任务ID获取收藏情况
        QueryWrapper<EmployeeBookmarked> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", id)
                .eq("task_id", taskId);
        EmployeeBookmarked employeeBookmarked = getOne(queryWrapper);

        // 如果查询到了说明雇员已经收藏该任务，取消收藏,删除该条记录
        if (employeeBookmarked != null) {
            remove(queryWrapper);
        }

        // 如果没有查询到，说明雇员没有收藏该任务，添加一条收藏记录
        else {
            employeeBookmarked = new EmployeeBookmarked();
            employeeBookmarked.setId(IDUtil.getRandomId());
            employeeBookmarked.setEmployeeId(id);
            employeeBookmarked.setTaskId(taskId);
            employeeBookmarkedMapper.insert(employeeBookmarked);
        }

        return employeeBookmarked;
    }

    @Override
    public List<EmployeeBookmarkedVo> getByEmployeeId(Long employeeId) {
        List<EmployeeBookmarked> employeeBookmarkeds = list(new QueryWrapper<EmployeeBookmarked>().eq("employee_id", employeeId));
        // 转换为视图展示对象
        List<EmployeeBookmarkedVo> employeeBookmarkedVos = new ArrayList<>();
        for (EmployeeBookmarked employeeBookmarked : employeeBookmarkeds) {
            // 创建一个 Vo 对象
            EmployeeBookmarkedVo employeeBookmarkedVo = new EmployeeBookmarkedVo();
            // 设置 ID
            employeeBookmarkedVo.setId(employeeId);
            // 查询任务信息
            TaskVo taskVo = taskService.getById(employeeBookmarked.getTaskId());
            // 设置任务信息
            employeeBookmarkedVo.setTaskVo(taskVo);
            employeeBookmarkedVos.add(employeeBookmarkedVo);
        }
        return employeeBookmarkedVos;
    }

    @Override
    public List<Long> getIdsByEmployeeId(Long employeeId) {
        List<EmployeeBookmarked> employeeBookmarkeds = list(new QueryWrapper<EmployeeBookmarked>().eq("employee_id", employeeId));
        List<Long> ids = new ArrayList<>();
        for (EmployeeBookmarked employeeBookmarked : employeeBookmarkeds) {
            Long aLong = employeeBookmarked.getTaskId();
            ids.add(aLong);
        }
        return ids;
    }

    @Override
    public void remove(Long id, Long taskId) {
        // 构造查询条件
        QueryWrapper<EmployeeBookmarked> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", id)
                .eq("task_id", taskId);
        // 删除收藏
        remove(queryWrapper);
    }
}
