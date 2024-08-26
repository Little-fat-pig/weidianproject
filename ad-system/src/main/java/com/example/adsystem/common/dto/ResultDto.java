package com.example.adsystem.common.dto;

import lombok.Data;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/7/19 17:01
 */
@Data
public class ResultDto<T> {

    private Integer pageNo;

    private Integer pageSize;

    private Integer total;

    private T data;

}
