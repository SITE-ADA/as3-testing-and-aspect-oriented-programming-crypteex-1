package homework3_client.Farid_Mehdiyev_Client.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* homework3_client.Farid_Mehdiyev_Client.Controller.*.*(..))")
    public void logBefore() {
        logger.info("Handling request...");
    }

    @AfterReturning(pointcut = "execution(* homework3_client.Farid_Mehdiyev_Client.Controller.*.*(..))", returning = "result")
    public void logAfter(Object result) {
        logger.info("Response: " + result);
    }
}
