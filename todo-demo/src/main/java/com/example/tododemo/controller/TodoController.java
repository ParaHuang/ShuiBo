package com.example.tododemo.controller;

import com.example.tododemo.entity.Todo;
import com.example.tododemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/getAllTodos")
    public List<Todo> getAllTodos(){
        return todoService.getAll();
    }

}
