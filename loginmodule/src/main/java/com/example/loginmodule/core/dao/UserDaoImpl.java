package com.example.loginmodule.core.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loginmodule.core.entity.UserEntity;
import com.example.loginmodule.core.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/13 19:25
 */
@Repository
public class UserDaoImpl {

    @Autowired
    private UserMapper userMapper;


    public UserEntity queryUserInfo(String username) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

}
