package com.example.adsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.adsystem.common.dto.BaseResult;

import com.example.adsystem.core.entity.AdSystemEntity;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/26 17:09
 */
public interface AdSystemService extends IService<AdSystemEntity> {

    /**
     * 获取全部的广告信息
     *
     * @return
     */
    BaseResult<?> queryAdInfo();
}
