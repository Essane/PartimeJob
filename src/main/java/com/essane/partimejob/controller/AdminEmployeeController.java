package com.essane.partimejob.controller;

import com.essane.partimejob.domain.Employee;
import com.essane.partimejob.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员雇员管理控制器
 *
 * @author by Essane
 * @Classname AdminEmployeeController
 * @Date 2019/10/14 9:48
 * @see com.essane.partimejob.controller
 */
@Controller
@RequestMapping("admin/employee")
public class AdminEmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 跳转到雇主列表页
     *
     * @return
     */
    @GetMapping("")
    public String taskCategory(Model model) {
        // 查询所有分类
        List<Employee> employees = employeeService.list();

        // 设置到域对象中，提供给页面展示
        model.addAttribute("employees", employees);
        return "admin/employee";
    }
}
