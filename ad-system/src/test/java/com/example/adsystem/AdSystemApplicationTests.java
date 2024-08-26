package com.example.adsystem;

import com.example.adsystem.core.entity.AdSystemEntity;
import com.example.adsystem.service.AdSystemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class AdSystemApplicationTests {

    @Autowired
    AdSystemService adSystemService;

    @Test
    void contextLoads() {

        AdSystemEntity build = AdSystemEntity.builder().adId(UUID.randomUUID().toString().replaceAll("-",""))
                .adBusinessId("afas").adPicUrl("http://www.baidu.com").adPicJumpUrl("http://www.baidu.com")
                .adTitle("婴儿好奶粉，呵护宝宝健康").tipContent("图片为产品广告，实际效果依据实际产品")
                .tip("广告").adStartTime(new Date()).adLimitTime(new Date())
                .createTime(new Date()).updateTime(new Date()).build();


        adSystemService.save(build);
    }

}
