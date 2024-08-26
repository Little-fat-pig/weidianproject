package com.example.adsystem.core;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/26 16:55
 * 公共字段类
 *
 */
@Data
public class BaseFieldEntity {

    /**
     * 广告的标识
     */
    private String tipContent;

    /**
     * 说明是广告
     */
    private String tip;

}
