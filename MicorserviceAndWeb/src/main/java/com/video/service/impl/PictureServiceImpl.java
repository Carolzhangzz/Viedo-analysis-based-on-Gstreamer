package com.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.dao.PictureDao;
import com.video.entity.Picture;
import com.video.service.PictureService;
import org.springframework.stereotype.Service;

/**
 * (Picture)表服务实现类
 *
 * @author makejava
 * @since 2023-05-06 21:14:10
 */
@Service("pictureService")
public class PictureServiceImpl extends ServiceImpl<PictureDao, Picture> implements PictureService {

}

