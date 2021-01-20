package by.teachmeskills.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OperationAspect {

    @Pointcut("execution(* by.teachmeskills.opetation.ISimpleOperation.process(..))")
    public void allProcessMethods() {}

    @Pointcut("execution(* by.teachmeskills.opetation.division.DivisionOperation.process(..))")
    public void divisionProcessMethod() {}

    @Around("allProcessMethods()")
    public Object aroundProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        final long end = System.currentTimeMillis();
        System.out.println("Processing time: " + (end - start));
        return result;
    }

    @AfterThrowing(value = "allProcessMethods()", throwing = "e")
    public void afterProcessThrows(Throwable e) {
        e.printStackTrace();
    }

    @Before("divisionProcessMethod()")
    public void beforeDivisionProcess(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (((Integer) args[1]) == 0) {
            args[1] = 1;
        }
    }

}
