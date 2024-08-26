package com.example.adsystem.apiweb.reception;

import com.example.adsystem.common.dto.BaseResult;
import com.example.adsystem.service.AdSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/26 17:42
 */
@Api(value = "广告推荐系统前台web接口", tags = {"广告推荐系统前台web接口"}, consumes = "application/json")
@RestController
public class AdSystemController {

    @Autowired
    private AdSystemService adSystemService;
    @ApiOperation(value = "获取全部的广告信息", httpMethod = "GET", notes = "获取全部的广告信息", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @RequestMapping(value = "/ap1/v1/adSystem/query/ad/info",method = RequestMethod.GET)
    public BaseResult<?> queryAdList() {
        return adSystemService.queryAdInfo();
    }


}
