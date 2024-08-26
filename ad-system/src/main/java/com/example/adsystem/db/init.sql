

DROP TABLE IF EXISTS tb_ad_info;

CREATE TABLE tb_ad_info(
                           ad_id varchar(200) PRIMARY KEY NOT null  COMMENT '广告的id',
                           ad_business_id varchar(200) COMMENT '广告的商户id',
                           ad_pic_url varchar(200) COMMENT '广告图片的url，广告采用了mini对象存储',
                           ad_pic_jump_url varchar(200) COMMENT '广告图片的链接url，跳转到广告的产品页面',

                           ad_title varchar(200) COMMENT '广告语，好的广告语能够起到事半功倍的效果',
                           tip_content varchar(200) COMMENT '广告的标识',
                           tip varchar(200) COMMENT '说明是广告',
                           ad_start_time timestamp COMMENT '广告开始时间',
                           ad_limit_time timestamp COMMENT '广告结束时间',
                           create_time timestamp  COMMENT '用户注册时间',
                           update_time timestamp COMMENT '用户更新时间'
)ENGINE=InnoDB COMMENT='广告信息表' DEFAULT CHARACTER SET utf8;