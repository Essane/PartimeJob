package com.essane.partimejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.essane.partimejob.domain.Employer;
import com.essane.partimejob.domain.HomeBower;
import com.essane.partimejob.mapper.EmployerMapper;
import com.essane.partimejob.mapper.HomeBowerMapper;
import com.essane.partimejob.service.HomeBowerService;
import com.essane.partimejob.vo.HomeBowerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页业务逻辑接口实现
 *
 * @author Essane
 */
@Service
public class HomeBowerServiceImpl extends ServiceImpl<HomeBowerMapper, HomeBower> implements HomeBowerService {
    @Resource
    private EmployerMapper employerMapper;

    @Override
    public List<HomeBowerVo> getByRecentlyEmployeeId(Long id) {
        // 构造查询条件
        QueryWrapper<HomeBower> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", id);
        // 分页查询
        // 获取最近 10 条浏览情况
        List<HomeBower> homeBowers = getBaseMapper().selectPage(new Page<>(1, 10), queryWrapper).getRecords();

        // 将 HomeBower 转换为 HomeBowerVo 视图展示对象
        List<HomeBowerVo> homeBowerVos = new ArrayList<>();
        for (HomeBower homeBower : homeBowers) {
            // 创建一个 HomeBowerVo 对象
            HomeBowerVo homeBowerVo = new HomeBowerVo();
            // 相同的属性进行复制
            BeanUtils.copyProperties(homeBower, homeBowerVo);
            // 查询雇主信息
            Employer employer = employerMapper.selectById(homeBower.getEmployerId());
            homeBowerVo.setEmployer(employer);
            // 添加到集合中
            homeBowerVos.add(homeBowerVo);
        }
        return homeBowerVos;
    }
}
