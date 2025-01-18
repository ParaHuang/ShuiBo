package com.example.tododemo.service;

import com.example.tododemo.entity.Todo;
import com.example.tododemo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
}
