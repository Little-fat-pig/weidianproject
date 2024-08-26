package com.example.adsystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.adsystem.common.dto.BaseResult;
import com.example.adsystem.core.entity.AdSystemEntity;
import com.example.adsystem.core.mapper.AdSystemMapper;
import com.example.adsystem.service.AdSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/26 17:10
 * 广告推荐系统业务逻辑处理类
 */
@Service
@Slf4j
public class AdSystemServiceImpl extends ServiceImpl<AdSystemMapper, AdSystemEntity> implements AdSystemService {

    @Override
    public BaseResult<List<AdSystemEntity>> queryAdInfo() {
        BaseResult<List<AdSystemEntity>> baseResult = new BaseResult<>();

        //获取广告系统数据，需要更改为分页接口实现，如果查询大量的数据，会导致前端页面卡死   后续在调整

        List<AdSystemEntity> adSystemEntityList = list();
        log.info("获取广告推荐系统中的所有推荐广告信息{}", adSystemEntityList);
        if (ObjectUtils.isEmpty(adSystemEntityList)) {
            baseResult.setCode("-1");
            baseResult.setMsg("失败，没有任何广告信息");
            return baseResult;
        }
        baseResult.setCode("0");
        baseResult.setData(adSystemEntityList);
        baseResult.setMsg("成功！");
        return baseResult;
    }
}
