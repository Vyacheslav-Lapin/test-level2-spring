package ru.vlapin.experiments.testlevel2spring.common;

import static ru.vlapin.experiments.testlevel2spring.common.LogLevel.INFO;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.BiConsumer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @SneakyThrows
  @Around("@annotation(Loggable) && args(id)")
  Object aroundAdvice(@NotNull ProceedingJoinPoint pjp, int id) {
    val name = pjp.getSignature().getName();
    val args = pjp.getArgs();
    val logMethod = getLogMethod(pjp);

    logMethod.accept("Method {} was called with {} arguments", new Object[]{logMethod, args});

    val result = pjp.proceed();

    logMethod.accept("Method {} returns {} for args {}", new Object[]{logMethod, result, args});

    return result;
  }

  @NotNull
  private static BiConsumer<String, Object[]> getLogMethod(ProceedingJoinPoint pjp) {
    return switch (getMethod(pjp)
                       .map(method -> method.getAnnotation(Loggable.class).value())
                       .orElse(INFO)) {
      case ERROR -> log::error;
      case WARN -> log::warn;
      case DEBUG -> log::debug;
      case TRACE -> log::trace;
      case INFO -> log::info;
    };
  }

  @SneakyThrows
  static Optional<Method> getMethod(ProceedingJoinPoint pjp) {
    if (pjp.getSignature() instanceof MethodSignature signature) {
      val method = signature.getMethod();
      return Optional.of(method.getDeclaringClass().isInterface() ?
                             pjp.getTarget().getClass().getDeclaredMethod(signature.getName(), method.getParameterTypes()) :
                             method);
    } else
      return Optional.empty();
  }
}
