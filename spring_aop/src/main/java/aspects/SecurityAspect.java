package aspects;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class SecurityAspect {

  private Logger logger =
      Logger.getLogger(SecurityAspect.class.getName());

  @Around("@annotation(AnnotationAspect)")
  public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {

    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();

    logger.info(
        "Security Aspect: Calling the  @AnnotationAspect intercepted method:" + methodName + " with params: " + Arrays
            .asList(arguments));

    // 呼叫 proceed, 會先執行下一個 Aspect or intercepted method
    Object returnedValue = joinPoint.proceed();

    logger.info("Security Aspect: Method executed and returned " +
        returnedValue);

    return returnedValue;
  }
}
