package com.example.loginmodule.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.loginmodule.core.entity.UserEntity;
import com.example.loginmodule.result.BaseResult;


/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/13 19:26
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 用户第一次登录，用户注册并且实现登录
     *
     * @param user
     * @return
     */
    BaseResult<?> loginOrRegister(UserEntity user);


    /**
     * 这里需要一个修改密码的方法    这个明天在开发
     *
     */

}
