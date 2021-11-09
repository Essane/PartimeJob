package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.domain.Employer;
import com.essane.partimejob.domain.TaskSkill;
import com.essane.partimejob.mapper.EmployerMapper;
import com.essane.partimejob.mapper.TaskSkillMapper;
import com.essane.partimejob.service.EmployerService;
import com.essane.partimejob.utils.IDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 雇主业务逻辑实现
 *
 * @author Essane
 */
@Service
public class EmployerServiceImpl extends ServiceImpl<EmployerMapper, Employer> implements EmployerService {

    @Resource
    private EmployerMapper employerMapper;

    @Resource
    private TaskSkillMapper taskSkillMapper;

    @Override
    public Integer getAllCount() {
        // 调用 employerMapper 查询所有雇主数据
        List<Employer> employers = list();
        // 三元表达式返回总数，如果 employers 不为空返回集合的数据，为空返回 0
        return employers != null ? employers.size() : 0;
    }


    @Override
    public Employer getByUsername(String username) {
        // 构造查询条件
        // 根据用户名查询
        QueryWrapper<Employer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        // 执行查询
        return getOne(queryWrapper);
    }

    @Override
    public void register(String username, String password) {
        Employer employer = new Employer();
        // 设置 ID,使用 IDUtil 获取随机ID
        employer.setId(IDUtil.getRandomId());
        // 设置用户名
        employer.setUsername(username);
        // 设置密码
        employer.setPassword(password);
        // 设置创建时间
        employer.setCreateTime(new Date());
        // 设置默认头像
        employer.setHeadImg("http://recruit1.oss-cn-shenzhen.aliyuncs.com/10f65b3a-e73d-4d8b-b95b-3841534ea0dc.png");
        // 插入到数据库
        employerMapper.insert(employer);
    }

    @Override
    public Employer login(String username, String password) {
        // 根据用户名获取用户信息
        Employer employer = getByUsername(username);

        // 验证密码是否正确,密码一致登录成功
        if (employer != null && employer.getPassword().equals(password)) {
            return employer;
        }

        // 密码不一致，返回 null
        return null;
    }

    @Override
    public void addSkill(Long taskId, String skillName) {
        TaskSkill taskSkill = new TaskSkill();
        taskSkill.setId(IDUtil.getRandomId());
        taskSkill.setTaskId(taskId);
        taskSkill.setSkillName(skillName);
        taskSkillMapper.insert(taskSkill);
    }

    @Override
    public void deleteSkill(Long skillId) {
        removeById(skillId);
    }


    @Override
    public String updatePass(Long employerId, String password, String newPassword) {
        // 根据主键查询雇员ID信息
        Employer employer = getById(employerId);
        // 更新密码
        if (employer != null && employer.getPassword().equals(password)) {
            employer.setPassword(newPassword);
            updateById(employer);
            return "修改密码成功";
        } else {
            // 旧密码错误
            return "旧密码输入错误";
        }
    }
}


