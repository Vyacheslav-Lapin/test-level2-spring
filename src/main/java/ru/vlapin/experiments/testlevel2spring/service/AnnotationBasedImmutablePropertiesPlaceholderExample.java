package ru.vlapin.experiments.testlevel2spring.service;

import static lombok.AccessLevel.PRIVATE;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import ru.vlapin.experiments.testlevel2spring.common.LogLevel;
import ru.vlapin.experiments.testlevel2spring.common.Loggable;
import ru.vlapin.experiments.testlevel2spring.dao.CatRepository;
import ru.vlapin.experiments.testlevel2spring.model.Cat;

/**
 * Limitations:
 * - no defaults (!!!)
 */
@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties("mail.credentials")
public class AnnotationBasedImmutablePropertiesPlaceholderExample {

  @NonFinal
  @Setter(value = PRIVATE, onMethod_ = @Autowired)
  CatRepository catRepository;

  /**
   * Auth method
   */
  String authMethod;

  /**
   * login
   */
  String username;

  /**
   * pwd
   */
  String password;

  @Loggable(LogLevel.WARN)
  public Cat getCat(int id) {
    return catRepository.findAll().get(0);
  }
}
