package com.cybertek.aspects;


import com.cybertek.controller.ProductController;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
//1st way
//    @Pointcut("execution(* com.cybertek.controller.ProductController.*(..))")
//    public void pointcut(){}
//
//    @Before("pointcut()")
//    public void log(){
//        logger.info("--------------");
//    }
//
//2nd way
//    @Before("execution(* com.cybertek.controller.ProductController.*(..))")
//    public void beforeAdvice(){
//        logger.info("--------------");
//    }
//    execution

    @Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")
    public void anyUpdateOperation(){}

    @Pointcut("execution(* com.cybertek.repository.ProductRepository.findById(Long))")
    public void anyProductRepositoryFindById(){}





}
