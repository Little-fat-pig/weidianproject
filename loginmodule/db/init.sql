DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user(
                        user_id varchar(200) PRIMARY KEY NOT null  COMMENT '用户id',
                        username varchar(200) COMMENT '用户名， 手机号或者邮箱',
                        password varchar(200) COMMENT '用户密码，8-20为字母、数字、特殊符号组成，首字母必须时字符',
                        password_hash_code int COMMENT '用户密码的hashcode值',
                        create_time timestamp  COMMENT '用户注册时间',
                        update_time timestamp COMMENT '用户更新时间'
)ENGINE=InnoDB COMMENT='用户表' DEFAULT CHARACTER SET utf8;


