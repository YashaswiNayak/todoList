package com.github.yashaswi.todoList.controller;

import com.github.yashaswi.todoList.dto.PriorityUpdateRequest;
import com.github.yashaswi.todoList.dto.TaskCreateRequest;
import com.github.yashaswi.todoList.dto.TaskUpdateRequest;
import com.github.yashaswi.todoList.model.Priority;
import com.github.yashaswi.todoList.model.Task;
import com.github.yashaswi.todoList.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

//_____________________________________________Get Mapping______________________________________________________________

    @GetMapping("/")
    public String defaultPage(){
        return "Welcome to my todo list";
    }

    @GetMapping("/tasks")
    public List<Task> displayAllTasks(
            @RequestParam(required = false) Boolean status,
            @RequestParam(required = false) Boolean deleted,
            @RequestParam(required = false) String due,
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false,defaultValue = "dueDate") String sortBy,
            @RequestParam(required = false,defaultValue = "asc") String order
    ) {
        return taskService.getFilteredTasks(status, deleted, due, priority,sortBy,order);
    }

    @GetMapping("/tasks/{id}")
    public  Task displayTaskById(@PathVariable Integer id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/tasks/search")
    public List<Task> keywordSearch(@RequestParam(required = true) String keyword){
        return taskService.searchForTasks(keyword);
    }
//__________________________________________Post Mapping________________________________________________________________

    @PostMapping("/create")
    public Task createNewTask(@RequestBody TaskCreateRequest request){
        return taskService.createTask(request);
    }

//__________________________________________Delete Mapping______________________________________________________________

    @DeleteMapping("/tasks/delete/{id}")
    public void deleteTask(@PathVariable Integer id){
            taskService.deleteTask(id);
    }

//__________________________________________Put  Mapping_________________________________________________________________

    @PutMapping("tasks/{id}/done")
    public Task updateTask(@PathVariable Integer id){
        return taskService.updateTaskStatus(id);
    }

    @PutMapping("tasks/{id}/edit")
    public Task updateTaskDefinition(@PathVariable Integer id, @RequestBody TaskUpdateRequest request){
        return taskService.updateTaskDefinition(id,request);
    }

    @PutMapping("tasks/{id}/restore")
    public void restoreDeletedTask(@PathVariable Integer id){
        taskService.restoreDeletedTask(id);
    }

    @PutMapping("tasks/{id}/priority")
    public void changePriority(@PathVariable Integer id, @RequestBody PriorityUpdateRequest priority){
        taskService.changePriority(id,priority);
    }

}
