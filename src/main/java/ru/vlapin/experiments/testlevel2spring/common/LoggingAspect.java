package ru.vlapin.experiments.testlevel2spring.common;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @SneakyThrows
  @Around("@annotation(Loggable)")
  Object aroundAdvice(@NotNull ProceedingJoinPoint joinPoint) {
    val name = joinPoint.getSignature().getName();
    val args = joinPoint.getArgs();

    log.info("Method {} was called with args: {}", name, args);

    val result = joinPoint.proceed(args);

    log.info("Method {}, was called with {} args, and returned: {}",
        name,
        args,
        result);

    return result;
  }
}
