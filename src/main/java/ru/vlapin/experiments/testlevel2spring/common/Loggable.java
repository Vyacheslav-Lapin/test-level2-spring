package ru.vlapin.experiments.testlevel2spring.common;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static ru.vlapin.experiments.testlevel2spring.common.LogLevel.INFO;

import java.lang.annotation.Retention;

/**
 * @see LoggingAspect#aroundAdvice
 */
@Retention(RUNTIME)
public @interface Loggable {

  LogLevel value() default INFO;
}
