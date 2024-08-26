package com.example.adsystem.common.config;

import io.swagger.models.auth.In;
import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2023/4/18 15:21
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * swagger文档地址
     *
     * http://10.192.19.122:8096/swagger-ui/index.html
     */


    @Value("${swagger.enable}")
    private Boolean enable;

    /**
     * 可以不加
     * 项目应用名(访问swagger的地址需要加的名称（如：http://10.192.14.46:8096/cadapds/swagger-ui/index.html）)
     */

    /**
     * 分组管理接口
     * RequestHandlerSelectors.basePackage   使用频率较高
     * RequestHandlerSelectors.any  扫描的类太多，尽量少使用
     * @return
     */

    @Bean()
    public Docket createRestApi1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("接口分组-广告推荐系统前台模块").enable(enable)
                // 用于生成API信息
                .apiInfo(apiInfo())
                .select()
                .apis(setControllerPath()).build();
    }
//    @Bean
//    public Docket createRestApi2() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("s2").enable(enable).apiInfo(apiInfo())
//                .select().apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//
//    @Bean
//    public Docket createRestApi3() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("s3").enable(enable).apiInfo(apiInfo())
//                .select().apis(RequestHandlerSelectors.basePackage("com.hikvision.cadapds.meetingvideorecording.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public Docket createRestApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.enable(enable);
        docket.apiInfo(apiInfo());

        ApiSelectorBuilder apiSelectorBuilder=new ApiSelectorBuilder(docket);
        apiSelectorBuilder.apis(setControllerPath());
        apiSelectorBuilder.paths(PathSelectors.any());
        docket.select();
        docket.enableUrlTemplating(true);
        docket.groupName("接口分组-订单模块1");

        return docket;
    }

    //配置需要扫描的接口包
    private Predicate<RequestHandler> setControllerPath(){
        Predicate<RequestHandler> predicate= RequestHandlerSelectors.basePackage("com.example.springtbootkey.controller");

        return predicate;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("swagger接口文档测试版本",
                "此部分接口为异步执行接口文档",
                "1.0",
                "http://10.192.19.122:8096/swagger-ui/index.html",
                new Contact("张学良", "https://github.com/paascloud/paascloud-master", "zxlmufu@163.com"),
                "西红柿",
                "1", new ArrayList());

    }


    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("BASE_TOKEN", "token", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

//    /**
//     * 授权信息全局应用
//     */
//    private List<SecurityContext> securityContexts() {
//        return Collections.singletonList(
//                SecurityContext.builder()
//                        .securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[]{new AuthorizationScope("global", "")})))
//                        .build()
//        );
//    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

    /**
     * 通用拦截器排除swagger设置，所有拦截器都会自动加swagger相关的资源排除信息
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            Field registrationsField = FieldUtils.getField(InterceptorRegistry.class, "registrations", true);
            List<InterceptorRegistration> registrations = (List<InterceptorRegistration>) ReflectionUtils.getField(registrationsField, registry);
            if (registrations != null) {
                for (InterceptorRegistration interceptorRegistration : registrations) {
                    interceptorRegistration
                            .excludePathPatterns("/swagger**/**")
                            .excludePathPatterns("/webjars/**")
                            .excludePathPatterns("/v3/**")
                            .excludePathPatterns("/doc.html");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

