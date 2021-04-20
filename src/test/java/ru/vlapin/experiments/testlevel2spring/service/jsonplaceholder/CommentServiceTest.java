package ru.vlapin.experiments.testlevel2spring.service.jsonplaceholder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CommentServiceTest {

  public static final long POST_ID = 1L;

  CommentService commentService;

  @Test
  @SneakyThrows
  @DisplayName("Comments feign client works correctly")
  void commentsFeignClientWorksCorrectlyTest() {
    assertThat(commentService.commentsByPostId(POST_ID)).isNotNull()
        .matches(listResponseEntity -> listResponseEntity.getStatusCode().is2xxSuccessful())
        .matches(listResponseEntity -> listResponseEntity.getStatusCode() == OK)
        .matches(listResponseEntity -> listResponseEntity.getHeaders().containsKey("Content-Type"))
        .matches(listResponseEntity -> APPLICATION_JSON.isCompatibleWith(listResponseEntity.getHeaders().getContentType()))
        .extracting(HttpEntity::getBody).asList()
        .hasSize(5);
  }
}
