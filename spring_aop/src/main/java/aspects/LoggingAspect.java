package aspects;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class LoggingAspect {

  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  /**
   * 指定執行 packages: services.CommentService 的任何 method
   *
   * @param joinPoint
   * @throws Throwable
   */
  @Around("execution( * services.CommentService.*(..))")
  public void log(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();

    logger.info(
        "Logging Aspect: Calling the CommentService intercepted method:" + methodName + " with params: " + Arrays
            .asList(arguments));

    joinPoint.proceed();

    logger.info("CommentService intercepted method executed");
  }

  /**
   * 指定執行在 method 加入 annotation: Annotation_Aspect 的任何 method
   *
   * @param joinPoint
   * @return
   * @throws Throwable
   */
  @Around("@annotation(Annotation_Aspect)")
  public Object annotationAOP(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    Object[] arguments = joinPoint.getArgs();

    logger.info(
        "Logging Aspect: Calling the @Annotation_Aspect intercepted method:" + methodName + " with params: " + Arrays
            .asList(arguments));

    // 呼叫 proceed, 會先執行下一個 Aspect or intercepted method
    Object returnedByMethod = joinPoint.proceed();

    logger.info("Logging Aspect: @Annotation_Aspect intercepted method executed and returned " +
        returnedByMethod);

    return returnedByMethod;

  }
}
