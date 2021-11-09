package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.domain.Employee;
import com.essane.partimejob.domain.EmployeeSkill;
import com.essane.partimejob.domain.HomeBower;
import com.essane.partimejob.mapper.EmployeeMapper;
import com.essane.partimejob.mapper.EmployeeSkillMapper;
import com.essane.partimejob.mapper.HomeBowerMapper;
import com.essane.partimejob.service.EmployeeService;
import com.essane.partimejob.utils.IDUtil;
import com.essane.partimejob.vo.EmployeeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 雇员业务逻辑实现
 *
 * @author Essane
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private EmployeeSkillMapper employeeSkillMapper;

    @Resource
    private HomeBowerMapper homeBowerMapper;

    @Override
    public Integer getAllCount() {
        List<Employee> employees = list();
        return employees != null ? employees.size() : 0;
    }

    @Override
    public List<Employee> getRecently() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return getBaseMapper().selectPage(new Page<>(0, 10), queryWrapper).getRecords();
    }

    @Override
    public Employee getByUsername(String username) {
        // 构造查询条件
        // 按用户名查询
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>().eq("username", username);
        return getOne(queryWrapper);
    }

    @Override
    public void register(String username, String password) {
        // 新建一个雇员实体类
        Employee employee = new Employee();
        // 设置 ID
        employee.setId(IDUtil.getRandomId());
        // 设置用户名
        employee.setUsername(username);
        // 设置密码
        employee.setPassword(password);
        // 设置创建时间
        employee.setCreateTime(new Date());
        // 设置主页点击次数
        employee.setBrowseCount(0);
        // 设置默认头像
        employee.setHeadImg("http://recruit1.oss-cn-shenzhen.aliyuncs.com/10f65b3a-e73d-4d8b-b95b-3841534ea0dc.png");

        // 插入到数据库
        employeeMapper.insert(employee);
    }

    @Override
    public Employee login(String username, String password) {
        // 根据用户名获取用户信息
        Employee employee = getByUsername(username);
        // 验证密码是否正确,密码一致登录成功
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }

        // 密码不一致，返回 null
        return null;
    }

    @Override
    public Integer getBowerCount(Long employeeId) {
        // 根据雇员主键ID查询出雇员信息
        Employee employee = getBaseMapper().selectById(employeeId);
        // 获取雇员主页浏览数量
        return employee.getBrowseCount();
    }


    @Override
    public String updatePass(Long employeeId, String password, String newPassword) {
        // 根据主键查询雇员ID信息
        Employee employee = getById(employeeId);
        // 更新密码
        if (employee != null && employee.getPassword().equals(password)) {
            employee.setPassword(newPassword);
            updateById(employee);
            return "修改密码成功";
        } else {
            // 旧密码错误
            return "旧密码输入错误";
        }
    }

    @Override
    public EmployeeVo getVoById(Long employeeId) {
        // 查询雇员信息
        Employee employee = getById(employeeId);
        // 查询雇员技能信息
        QueryWrapper<EmployeeSkill> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", employee.getId());
        // 转换为视图展示对象
        EmployeeVo employeeVo = new EmployeeVo();
        BeanUtils.copyProperties(employee, employeeVo);
        // 查询出雇员所有技能
        List<EmployeeSkill> employeeSkills = employeeSkillMapper.selectList(queryWrapper);
        employeeVo.setSkills(employeeSkills);
        return employeeVo;
    }

    @Override
    public void addSkill(Long id, String skillName) {
        // 创建一个技能实体类，添加到数据库
        EmployeeSkill employeeSkill = new EmployeeSkill();
        employeeSkill.setId(IDUtil.getRandomId());
        employeeSkill.setSkillName(skillName);
        employeeSkill.setEmployeeId(id);
        employeeSkillMapper.insert(employeeSkill);
    }

    @Override
    public void deleteSkill(Long skillId) {
        employeeSkillMapper.deleteById(skillId);
    }

    @Override
    public void bower(Long employeeId, Long employerId) {
        // 增加一条主页浏览记录
        HomeBower homeBower = new HomeBower();
        homeBower.setId(IDUtil.getRandomId());
        homeBower.setEmployeeId(employeeId);
        homeBower.setEmployerId(employerId);
        homeBower.setCreateTime(new Date());
        homeBowerMapper.insert(homeBower);
        // 雇员主页访问次数 + 1
        Employee employee = getById(employeeId);
        Integer bowerCount = employee.getBrowseCount() + 1;
        employee.setBrowseCount(bowerCount);
        updateById(employee);
    }
}


