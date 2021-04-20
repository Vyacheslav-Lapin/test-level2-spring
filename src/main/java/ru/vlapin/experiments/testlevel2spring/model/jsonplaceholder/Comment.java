package ru.vlapin.experiments.testlevel2spring.model.jsonplaceholder;

import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class Comment {

  Long postId;
  Long id;
  String name;

  @Pattern(regexp = "^[\\w.]+@[\\w.]+$")
  String email;

  String body;
}
