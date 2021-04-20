package ru.vlapin.experiments.testlevel2spring.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.testlevel2spring.model.Cat;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class AnnotationBasedImmutablePropertiesPlaceholderExampleTest {

  AnnotationBasedImmutablePropertiesPlaceholderExample catService;

  @Test
  @SneakyThrows
  @DisplayName("getCat method works correctly")
  void getCatMethodWorksCorrectlyTest() {
    Assertions.assertThat(catService.getCat()).isNotNull()
        .extracting(Cat::getName)
        .isNotNull();
  }
}
