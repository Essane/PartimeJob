package com.essane.partimejob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.essane.partimejob.domain.Employee;
import com.essane.partimejob.vo.EmployeeVo;

import java.util.List;

/**
 * 雇员业务逻辑接口
 *
 * @author Essane
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 查询雇员总数
     *
     * @return
     */
    Integer getAllCount();

    /**
     * 获取最近注册的 10 个会员
     *
     * @return
     */
    List<Employee> getRecently();


    /**
     * 根据用户名获取雇员信息
     *
     * @param username 用户名
     * @return
     */
    Employee getByUsername(String username);

    /**
     * 雇员注册
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    void register(String username, String password);

    /**
     * 雇员登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Employee login(String username, String password);

    /**
     * 总浏览次数
     *
     * @return
     */
    Integer getBowerCount(Long employeeId);

    /**
     * 修改密码
     *
     * @param password
     * @param newPassword
     * @return
     */
    String updatePass(Long employeeId, String password, String newPassword);

    /**
     * 根据 ID 获取雇员信息
     *
     * @param employeeId
     * @return
     */
    EmployeeVo getVoById(Long employeeId);

    /**
     * 添加技能
     *
     * @param id        雇员 ID
     * @param skillName 技能名称
     */
    void addSkill(Long id, String skillName);

    /**
     * 删除技能
     *
     * @param skillId
     */
    void deleteSkill(Long skillId);

    /**
     * 雇主浏览雇员简介页
     *
     * @param employeeId
     * @param id
     */
    void bower(Long employeeId, Long id);
}


