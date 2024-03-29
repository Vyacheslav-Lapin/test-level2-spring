package ru.vlapin.experiments.testlevel2spring.controller.jsonplaceholder;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.testlevel2spring.model.jsonplaceholder.Todo;
import ru.vlapin.experiments.testlevel2spring.service.jsonplaceholder.TodoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/todos")
public class TodoController {

  TodoService todoService;

  @NotNull
  @GetMapping
  public List<Todo> todos() {
    return todoService.all();
  }

  @GetMapping("{id}")
  public Todo todo(@PathVariable @NotNull Long id) {
    return todoService.findById(id);
  }
}
