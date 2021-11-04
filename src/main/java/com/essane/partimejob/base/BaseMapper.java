package com.essane.partimejob.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * tk.mybatis 通用的 Mapper 接口
 *
 * @author by yuu
 * @Classname MyMapper
 * @Date 2019/10/13 16:56
 * @see tk.mybatis.mapper
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
