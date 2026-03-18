package com.example.TodoRestApi.controller;

import com.example.TodoRestApi.model.Todo;
import com.example.TodoRestApi.services.TodoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoServices todoServices;

    Random random = new Random();

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        int id = random.nextInt(99999999);
        todo.setId(id);
      //  System.out.println("REQUEST REACHED TO CONTROLLER");
        logger.info("create todo");
        Todo todo1 = todoServices.createTodo(todo);
    //    System.out.println("REQUEST REACHED TO CONTROLLER NOW RETURNING");
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Todo> getTodo(){
        return todoServices.getTodo();
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodo(@PathVariable int todoId){
       Todo todo = todoServices.getTodoById(todoId);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updatedTodoList(@RequestBody Todo todoWithNewDetails,@PathVariable int todoId){
        Todo todo = todoServices.updateTodo(todoId,todoWithNewDetails);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodoById(@PathVariable int todoId){
        System.out.println("Delete request reached to controller");
        todoServices.deleteTodo(todoId);
    }
}
