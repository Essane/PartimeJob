package com.essane.partimejob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.essane.partimejob.domain.Employer;

import java.util.List;

/**
 * 雇主业务逻辑接口
 * @author Essane
 */
public interface EmployerService extends IService<Employer> {

    /**
     * 获取雇主总数
     *
     * @return
     */
    Integer getAllCount();

    /**
     * 根据用户名获取雇主信息
     *
     * @param username 用户名
     * @return
     */
    Employer getByUsername(String username);

    /**
     * 雇主注册
     *
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

    /**
     * 雇主登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Employer login(String username, String password);

    /**
     * 添加任务技能
     *
     * @param taskId    技能 ID
     * @param skillName 技能名称
     */
    void addSkill(Long taskId, String skillName);

    /**
     * 删除任务技能
     *
     * @param skillId
     */
    void deleteSkill(Long skillId);

    /**
     * 修改密码
     *
     * @param id          雇主 ID
     * @param password    密码
     * @param newPassword 新密码
     * @return
     */
    String updatePass(Long id, String password, String newPassword);
}


