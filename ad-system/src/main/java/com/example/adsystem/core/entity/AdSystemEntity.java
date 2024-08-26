package com.example.adsystem.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.adsystem.core.BaseFieldEntity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/26 16:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@TableName("tb_ad_info")
public class AdSystemEntity extends BaseFieldEntity implements Serializable {

    private static final long serialVersionUID = 1056244L;

    /**
     * 广告的id
     */
    @TableId(value = "ad_id", type = IdType.INPUT)
    private String adId;

    /**
     * 广告的商户id
     */
    @TableField(value = "ad_business_id")
    private String adBusinessId;

    /**
     * 广告图片的url，广告采用了mini对象存储
     */
    @TableField(value = "ad_pic_url")
    private String adPicUrl;

    /**
     * 广告图片的链接url，跳转到广告的产品页面
     */
    @TableField(value = "ad_pic_jump_url")
    private String adPicJumpUrl;


    /**
     * 广告语，好的广告语能够起到事半功倍的效果
     */
    @TableField(value = "ad_title")
    private String adTitle;

    /**
     * 广告的标识
     */
    @TableField("tip_content")
    private String tipContent;

    /**
     * 说明是广告
     */
    @TableField("tip")
    private String tip;


    /**
     * 广告开始时间
     */
    @TableField(value = "ad_start_time")
    private Date adStartTime;

    /**
     * 广告结束时间
     */
    @TableField(value = "ad_limit_time")
    private Date adLimitTime;


    /**
     * 广告推送时间
     */
    @TableField(value = "create_time")
    private Date createTime;


    /**
     * 广告更改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

}
