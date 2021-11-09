package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.domain.Admin;
import com.essane.partimejob.mapper.AdminMapper;
import com.essane.partimejob.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 管理员的业务逻辑实现
 *
 * @author Essane
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Admin login(Admin admin) {
        // 查询出用户名的管理员
        // 使用 queryWrapper 查询
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", admin.getUsername());
        Admin currAdmin = getOne(queryWrapper);
        // 判断密码是否正确, 密码采用 MD5 加密，所以需要把页面传过来的密码加密后进行比较
        if (currAdmin != null && currAdmin.getPassword().equals(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()))) {
            // 密码相同登录成功
            return currAdmin;
        }

        // 密码不相同，登录失败,返回一个 null 值
        else {
            return null;
        }
    }
}
