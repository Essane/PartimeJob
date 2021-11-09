package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.consts.BidStatus;
import com.essane.partimejob.consts.TaskStatus;
import com.essane.partimejob.domain.Bid;
import com.essane.partimejob.domain.Employee;
import com.essane.partimejob.domain.Task;
import com.essane.partimejob.mapper.BidMapper;
import com.essane.partimejob.mapper.EmployeeMapper;
import com.essane.partimejob.mapper.TaskMapper;
import com.essane.partimejob.service.BidService;
import com.essane.partimejob.vo.BidVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 雇员投标业务逻辑接口实现
 *
 * @author Essane
 */
@Service
public class BidServiceImpl extends ServiceImpl<BidMapper, Bid> implements BidService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private TaskMapper taskMapper;


    @Override
    public void bid(Bid bid) {
        save(bid);
    }

    @Override
    public boolean getBidByTaskIdAndEmployeeId(Long taskId, Long id) {
        QueryWrapper<Bid> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_id", taskId).eq("employee_id", id);
        Bid bid = getOne(queryWrapper);
        // 如果 bid 不为 null 代表已经投递过该任务
        return bid != null;
    }

    @Override
    public List<BidVo> getNoBitByEmployeeId(Long id) {
        QueryWrapper<Bid> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", id).eq("bid_status", BidStatus.NO_BIT);
        List<Bid> bids = list(queryWrapper);
        List<BidVo> bidVos = new ArrayList<>();
        for (Bid bid : bids) {
            BidVo bidVo = new BidVo();
            // 相同属性进行复制
            BeanUtils.copyProperties(bid, bidVo);
            // 根据投标雇员ID查询出雇员信息
            Employee currEmployee = employeeMapper.selectById(bid.getEmployeeId());
            bidVo.setEmployee(currEmployee);
            // 根据任务 ID 查询任务信息
            Task task = taskMapper.selectById(bid.getTaskId());
            bidVo.setTask(task);

            // 复制完值添加到集合中
            bidVos.add(bidVo);
        }
        return bidVos;
    }

    @Override
    public void deleteById(Long bid) {
        removeById(bid);
    }

    @Override
    public void acceptBid(Long taskId, Long employeeId) {
        // 先查询任务信息
        Task task = taskMapper.selectById(taskId);
        // 设置中标雇员信息
        task.setEmployeeId(employeeId);
        // 设置任务状态
        task.setTaskStatus(TaskStatus.BIT);
        // 设置中标时间
        task.setBidTime(new Date());
        // 查询投标信息，获取投标价格
        QueryWrapper<Bid> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_id", taskId).eq("employee_id", employeeId);
        Bid bid = getOne(queryWrapper);
        // 设置中标价格
        task.setTaskPrice(bid.getBidPrice());
        // 更新到数据库
        taskMapper.updateById(task);
        // 修改竞标状态
        Bid bid1 = getOne(new QueryWrapper<Bid>().eq("task_id", taskId).eq("employee_id", employeeId));
        bid1.setBidStatus(BidStatus.BIT);
        updateById(bid1);
    }
}





