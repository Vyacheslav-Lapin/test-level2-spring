package ru.vlapin.experiments.testlevel2spring.service.jsonplaceholder;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlapin.experiments.testlevel2spring.model.jsonplaceholder.Todo;

@FeignClient(
    name = "TodoJsonPlaceHolder",
    url = "https://jsonplaceholder.typicode.com",
    path = "todos")
public interface TodoService {

  @GetMapping
  List<Todo> all();

  @GetMapping("{id}")
  Todo findById(@PathVariable Long id);
}
