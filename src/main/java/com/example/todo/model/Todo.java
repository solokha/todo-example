package com.example.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Description is required")
    @Size(min = 10, message = "Description must be at least 10 characters long")
    private String description;

    private String status;

    @NotNull(message = "Username is required")
    private String username;
}
