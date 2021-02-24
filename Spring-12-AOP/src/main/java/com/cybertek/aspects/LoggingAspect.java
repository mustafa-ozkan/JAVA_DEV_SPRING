package com.cybertek.aspects;


import com.cybertek.controller.ProductController;
import com.cybertek.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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
    public void anyUpdateOperation() {
    }

    @Pointcut("execution(* com.cybertek.repository.ProductRepository.findById(long))")
    public void anyProductRepositoryFindById() {
    }

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(JoinPoint joinPoint) {
        logger.info("Before -> Controller:{} - method:{} - Input Parameter :{}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    @Before("anyUpdateOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint) {
        logger.info("Before -> Controller:{} - method:{} - Input Parameter :{}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //within
    @Pointcut("within(com.cybertek.controller..*)")
    private void anyControllerOperation() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation() {
    }

    //combine pointcuts
    @Before("anyServiceAnnotatedOperation() || anyControllerOperation()")
    public void beforeControllerAdvice2(JoinPoint joinPoint) {
        logger.info("Before -> Controller:{} - method:{} - Input Parameter :{}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //annotation
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation() {
    }

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice3(JoinPoint joinPoint) {
        logger.info("Before -> Controller:{} - method:{} - Input Parameter :{}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //Afterreturning
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){}

    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Product results){
        logger.info("After returning(Mono Result) -> Method :{} - results :{}", joinPoint.getSignature().toShortString(),results);
    }

    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results){
        logger.info("After returning(List Result) -> Method :{} - results :{}", joinPoint.getSignature().toShortString(),results);
    }
}
