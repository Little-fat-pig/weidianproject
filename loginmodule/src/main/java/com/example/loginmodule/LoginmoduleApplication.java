package com.example.loginmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAspectJAutoProxy
@EnableAsync
@EnableTransactionManagement
@EnableSwagger2
@EnableJms
@SpringBootApplication
public class LoginmoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginmoduleApplication.class, args);
    }

}
