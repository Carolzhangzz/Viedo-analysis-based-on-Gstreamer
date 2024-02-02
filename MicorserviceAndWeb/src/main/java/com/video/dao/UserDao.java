package com.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.video.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-07 14:00:31
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

