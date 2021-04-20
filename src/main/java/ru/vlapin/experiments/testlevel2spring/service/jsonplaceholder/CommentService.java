package ru.vlapin.experiments.testlevel2spring.service.jsonplaceholder;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlapin.experiments.testlevel2spring.model.jsonplaceholder.Comment;

@FeignClient(
    name = "CommentJsonPlaceHolder",
    url = "https://jsonplaceholder.typicode.com",
    path = "comments")
public interface CommentService {

  @GetMapping
  List<Comment> all();

  @GetMapping("{id}")
  Comment findById(@PathVariable Long id);

//  @GetMapping("posts/{postId}/comments")
  @GetMapping
  ResponseEntity<List<Comment>> commentsByPostId(@RequestParam @NotNull Long postId);
}
