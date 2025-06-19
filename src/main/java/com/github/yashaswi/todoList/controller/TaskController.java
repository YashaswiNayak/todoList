package com.github.yashaswi.todoList.controller;

import com.github.yashaswi.todoList.model.Task;
import com.github.yashaswi.todoList.service.TaskService;
import com.sun.source.util.TaskListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/")
    public String defaultPage(){
        return "Welcome to my todo list";
    }

    @GetMapping("/tasks")
    public List<Task> displayAllTasks(@RequestParam(required = false) Boolean status){
        if(status!=null){
            return taskService.getTaskByStatus(status);
        }
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public  Optional<Task> displayTaskById(@PathVariable Integer id){
        return taskService.getTaskById(id);
    }

    @PostMapping("/create")
    public Task createNewTask(@RequestBody String taskDefinition){
        return taskService.createTask(taskDefinition);
    }

    @DeleteMapping("/delete-task/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }

    @PutMapping("tasks/{id}/done")
    public Task updateTask(@PathVariable Integer id){
        return taskService.updateTaskStatus(id);
    }

}
