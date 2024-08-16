package com.example.loginmodule.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loginmodule.core.dao.UserDaoImpl;
import com.example.loginmodule.core.entity.UserEntity;
import com.example.loginmodule.core.mapper.UserMapper;
import com.example.loginmodule.result.BaseResult;
import com.example.loginmodule.service.UserService;
import com.example.loginmodule.util.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/13 19:26
 * 用户登录、注册业务类
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


    @Autowired
    private UserDaoImpl userDao;


    @Override
    public BaseResult<?> loginOrRegister(UserEntity user) {
        BaseResult<UserEntity> baseResult = new BaseResult<>();
        baseResult.setCode("-1");
        log.info("登录的用户信息{}", user);
        //下面两个判断，在前端进行过滤，减少io次数 +1
        if (ValidateUtils.isEmpty(user.getUsername())) {
            baseResult.setMsg("未输入用户名，请输入用户名");
            return baseResult;
        }

        if (ValidateUtils.isEmpty(user.getPassword())) {
            baseResult.setMsg("未输入密码，请输入密码");
            return baseResult;
        }

        UserEntity userEntity = userDao.queryUserInfo(user.getUsername());
        log.info("验证用户是否已经注册过{}", userEntity);
        int passwordHashCode = user.getPassword().hashCode();
        if (ValidateUtils.isEmpty(userEntity)) {
            //先注册，在返回用户登录的后的界面
            String userId = UUID.randomUUID().toString().replaceAll("-", "") + System.currentTimeMillis();
            //根据密码串生成hashcode
            UserEntity userEntityBuild = UserEntity.builder()
                    .userId(userId).username(user.getUsername()).password(user.getPassword())
                    .passwordHashCode(passwordHashCode).createTime(new Date()).updateTime(new Date()).build();
            //完成用户的注册
            save(userEntityBuild);

            //这种设计是，登录的时候设置好密码，不设置密码不能注册
            baseResult.setData(userEntityBuild);
            baseResult.setMsg("用户注册成功，返回登录页面");
        } else {
            if (userEntity.getPasswordHashCode().equals(passwordHashCode)) {
                //用户密码校验一致，用户登录成功
                baseResult.setData(userEntity);
                baseResult.setMsg("用户登录成功，返回登录页面");
            } else {
                baseResult.setMsg("用户名或者密码输入错误，请重新输入");
                return baseResult;
            }
        }
        baseResult.setCode("0");
        return baseResult;
    }
}
