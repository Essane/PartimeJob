package com.essane.partimejob.service;

import com.essane.partimejob.domain.Admin;

/**
 * 管理员的业务逻辑接口
 */
public interface AdminService {

    /**
     * 管理员登录
     *
     * @param admin 管理员
     * @return
     */
    Admin login(Admin admin);
}
