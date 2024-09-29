package com.example.loginmodule.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/1 20:24
 */
@Component
@Aspect
@Slf4j
public class TestAOP {

    //注解实现
    @Pointcut("@annotation(com.example.loginmodule.config.CreateAnnotation)")
    public void authCut() {
    }


//    @Before("authCut()")
//    public void cutProcess(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        log.info("通过开发一个注解结合aop思想开始执行方法" + method.getName() + "执行结束！");
//    }
//
//
//    @After("authCut()")
//    public void after(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        System.out.println("注解方式AOP执行的方法 :" + method.getName() + " 执行完了");
//    }


    @Around(value = "authCut()", argNames = "joinPoint")
    public Object testCutAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("第一步进入的是环绕通知1");
        System.out.println("注解方式AOP拦截开始进入环绕通知1.......");
        //这个时环绕通知的分水岭 上面的内容相当于 before
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Class[] parameterTypes = signature.getParameterTypes();

        log.info("请求参数{}", args);


        Object proceed = joinPoint.proceed(args);
        log.info("返回结果{}", proceed);
        //下面的内容相当于 after
        log.info("第二步退出的是环绕通知2");
        System.out.println("注解方式AOP拦截开始推出环绕通知2.......");
        return proceed;
    }


//    /**
//     * returning属性指定连接点方法返回的结果放置在result变量中
//     *
//     * @param joinPoint 连接点
//     * @param result    返回结果
//     */
//    @AfterReturning(value = "authCut()", returning = "result")
//    public void afterReturn(JoinPoint joinPoint, Object result) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        System.out.println("注解方式AOP拦截的方法执行成功, 进入返回通知拦截, 方法名为: " + method.getName() + ", 返回结果为: " + (result == null ? result : result.toString()));
//    }
//
//    @AfterThrowing(value = "authCut()", throwing = "e")
//    public void afterThrow(JoinPoint joinPoint, Exception e) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        System.out.println("注解方式AOP进入方法异常拦截, 方法名为: " + method.getName() + ", 异常信息为: " + e.getMessage());
//    }


}
