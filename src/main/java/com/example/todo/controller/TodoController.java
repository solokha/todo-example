package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    private final Logger logger = LoggerFactory.getLogger(TodoController.class);

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public Todo addTodo(@Valid @RequestBody Todo todo) {
        logger.info("addTodo() called");
        return todoService.saveTodo(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        logger.info("getAllTodos() called");
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        logger.info("getTodoById() called");
        return todoService.getTodo(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable Integer id, @Valid @RequestBody Todo todo) {
        logger.info("updateTodo() called");
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        logger.info("deleteTodo() called");
        todoService.deleteTodo(id);
    }

    @GetMapping("/todos/user/{username}")
    public List<Todo> getTodosByUsername(@PathVariable String username) {
        logger.info("getTodosByUsername() called");
        return todoService.getTodosByUsername(username);
    }
}
