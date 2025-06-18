package com.github.yashaswi.todoList.controller;

import com.github.yashaswi.todoList.model.Task;
import com.github.yashaswi.todoList.service.TaskService;
import com.sun.source.util.TaskListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/")
    public String defaultPage(){
        return "Default Page";
    }

    @GetMapping("/hello")
    public String printMessage(){
        return "Hello World - I am Alive";
    }

    @GetMapping("/tasks")
    public List<Task> displayAllTasks(){
        return taskService.getAllTasks();
    }



    @PostMapping("/create")
    public Task createNewTask(@RequestBody String taskDefinition){
        return taskService.createTask(taskDefinition);
    }




}
