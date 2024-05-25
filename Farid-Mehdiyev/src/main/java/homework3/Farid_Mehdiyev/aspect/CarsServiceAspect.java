package homework3.Farid_Mehdiyev.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import homework3.Farid_Mehdiyev.model.entity.Cars;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class CarsServiceAspect {


    @Pointcut("execution(*homework3.Farid_Mehdiyev.sertvice.impl..*(..))")
    private void methodPointCut(){

    }

    @Before(value = "methodPointCut()")
    public void before (JoinPoint jp) {

        log.info("Type of execution: " +jp.getKind());
        log.info("method {} is entered", jp.getSignature().getName());
        log.info("Number of Input parameters {}", jp.getArgs());

        Object[] args = jp.getArgs();
        log.info("Arguments: " + Arrays.toString(args));

    }


    @After("methodPointCut()")
    public void after(JoinPoint jp) {
        log.info("method {} is existing", jp.getSignature());
    }

    @AfterReturning(value = "methodPointCut()", returning = "returnValue")
    public void after(JoinPoint jp, Object returnValue){
        log.info("After method invoked::" + returnValue);
    }


    @AfterThrowing(value = "methodPointCut()", throwing = "e")
    public void after(JoinPoint jp, Exception e){
        log.info("After method invoked::" + e.getMessage());

    }

    @Around("methodPointCut()")
    @SneakyThrows
    public Object around(ProceedingJoinPoint pjp) {
        log.info("Before method invoked: " + pjp.getSignature());
        StopWatch watch = new StopWatch();
        watch.start();

    Object res = pjp.proceed();
    if (res instanceof Cars) {
        log.info("After method invoked: " + pjp.getSignature());
    }

    watch.stop();
    log.info("Time taken by method {} is {} millis", pjp.getSignature(), watch.getTotalTimeMillis());
        return res;

    }

}
