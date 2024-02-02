package com.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.dao.UserDao;
import com.video.entity.User;
import com.video.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-05-07 14:00:31
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

