package com.example.adsystem.core.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.adsystem.core.entity.AdSystemEntity;
import com.example.adsystem.core.mapper.AdSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/26 17:07
 */
@Repository
public class AdSystemDaoImpl {

    @Autowired
    private AdSystemMapper adSystemMapper;

    public List<AdSystemEntity> queryByAdId(String adId) {
        QueryWrapper<AdSystemEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ad_id", adId);
        return adSystemMapper.selectList(queryWrapper);
    }

}
