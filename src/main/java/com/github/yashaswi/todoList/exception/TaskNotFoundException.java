package com.github.yashaswi.todoList.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Integer id){
        super("Task with ID "+id+" not found");
    }
}
