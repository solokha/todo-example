package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(Integer id) {
        return todoRepository.findById(id).get();
    }

    public Todo getTodoByTitle(String title) {
        return todoRepository.findByTitle(title);
    }

    public List<Todo> getTodosByUsername(String username) {
        return todoRepository.findAllByUsername(username);
    }

    public Todo updateTodo(Integer id, Todo todo) {
        Todo todoToUpdate = todoRepository.findById(id).orElse(null);

        if (todoToUpdate == null) {
            throw new IllegalArgumentException("Todo with id " + id + " not found");
        }

        todoToUpdate.setTitle(todo.getTitle());
        todoToUpdate.setDescription(todo.getDescription());
        todoToUpdate.setStatus(todo.getStatus());
        todoToUpdate.setUsername(todo.getUsername());

        return todoRepository.save(todoToUpdate);
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }

}
