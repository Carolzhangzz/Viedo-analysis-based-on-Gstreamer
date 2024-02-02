package com.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.video.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Picture)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-06 21:14:07
 */
@Mapper
public interface PictureDao extends BaseMapper<Picture> {

}

