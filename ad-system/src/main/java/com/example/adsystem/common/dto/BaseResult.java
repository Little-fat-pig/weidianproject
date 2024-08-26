package com.example.adsystem.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/13 19:28
 * 定义一个接口返回结果的模板类
 */
@Data
@ApiModel(description = "接口返回结果")
public class BaseResult<T> {

    @ApiModelProperty(value = "code为0成功，其他值均为失败", name = "code", dataType = "String", example = "0或 0X00011", required = true)
    private String code;

    @ApiModelProperty(value = "接口返回信息的具体描述", name = "msg", dataType = "String", example = "成功或者登录异常", required = true)
    private String msg;

    @ApiModelProperty(value = "接口返回的具体数据信息", name = "data", required = true)
    private T data;
}
