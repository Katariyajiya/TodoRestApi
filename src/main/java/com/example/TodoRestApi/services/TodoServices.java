package com.example.TodoRestApi.services;

import com.example.TodoRestApi.exceptions.ResourceNotFoundException;
import com.example.TodoRestApi.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServices {

    Logger logger = LoggerFactory.getLogger(TodoServices.class);
    List<Todo> todos = new ArrayList<>();
    public Todo createTodo(Todo todo){
      //  System.out.println("REQUEST REACHED TO SERVICES");
        todos.add(todo);
        logger.info("Todos {}",this.todos);
        return todo;
    }

    public List<Todo> getTodo(){
        return todos;
    }

    public Todo getTodoById(int id){
      Todo todo = todos.stream().filter(t -> id == t.getId())
              .findAny().orElseThrow(() -> new ResourceNotFoundException("Todo npt found with given id", HttpStatus.NOT_FOUND));
      return todo;
    }

    public Todo updateTodo(int id,Todo todo){
       List<Todo> newUpdatedList = todos.stream().map(
               t->{
                   if (t.getId() == id){
                        t.setTitle(todo.getTitle());
                        t.setContent(todo.getContent());
                        t.setStatus(todo.getStatus());
                       return t;
                   }else {
                        return t;
                   }
               }).collect(Collectors.toList());
       todos=newUpdatedList;
       todo.setId(id);
        return todo;
    }

    public void deleteTodo(int id){
      List<Todo> newList = todos.stream().filter(t-> t.getId()!=id).collect(Collectors.toList());
      todos = newList;
    }
}
