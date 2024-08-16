package com.example.loginmodule.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.loginmodule.core.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/13 19:24
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
