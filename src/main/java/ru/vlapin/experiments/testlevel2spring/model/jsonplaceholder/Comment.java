package ru.vlapin.experiments.testlevel2spring.model.jsonplaceholder;

import static lombok.AccessLevel.PRIVATE;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class Comment {

  Long postId;
  Long id;
  String name;
  String email;
  String body;
}
