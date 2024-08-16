package com.example.loginmodule.core.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/13 19:11
 * 用户登录和注册表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户表")
@TableName("tb_user")
public class UserEntity implements Serializable {

    @TableId(value = "user_id", type = IdType.INPUT)
    @ApiModelProperty(value = "用户id", name = "userId", dataType = "String", example = "uuid+时间戳", required = true)
    private String userId;

    @TableField("username")
    @ApiModelProperty(value = "用户名称", name = "username", dataType = "String", example = "手机号、邮箱", required = true)
    private String username;

    @TableField("password")
    @ApiModelProperty(value = "用户密码", name = "password", dataType = "String", example = "8-20为字母、数字、特殊符号组成，首字母必须时字符", required = true)
    private String password;

    /**
     * 在用户输入正确密码时，对比hashcode，作为用户登录的认证方式
     */
    @TableField("password_hash_code")
    @ApiModelProperty(value = "用户密码的hashcode值", name = "passwordHashCode", dataType = "Integer", example = "hashcode值", required = true)
    private Integer passwordHashCode;


    @TableField("create_time")
    @ApiModelProperty(value = "用户注册时间", name = "createTime", dataType = "timestamp", example = "2024-08-13-20.28.23 +0800", required = true)
    private Date createTime;


    /**
     * 在用户输入正确密码时，对比hashcode，作为用户登录的认证方式
     */
    @TableField("update_time")
    @ApiModelProperty(value = "用户更新时间", name = "updateTime", dataType = "timestamp", example = "2024-08-13-20.28.23 +0800", required = true)
    private Date updateTime;
}
