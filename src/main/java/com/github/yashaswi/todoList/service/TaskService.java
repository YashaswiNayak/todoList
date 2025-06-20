package com.github.yashaswi.todoList.service;

import com.github.yashaswi.todoList.dto.TaskCreateRequest;
import com.github.yashaswi.todoList.dto.TaskUpdateRequest;
import com.github.yashaswi.todoList.model.Task;
import com.github.yashaswi.todoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskCreateRequest request) {
        Task task=new Task();
        task.setTask(request.getTask());
        task.setStatus(request.getStatus());
        taskRepository.save(task);
        return task;
    }

    public Optional<Task> getTaskById(Integer id){
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
        System.out.print("Task with id: "+id+" has been deleted");
    }

    public List<Task> getTaskByStatus(Boolean status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTaskStatus(Integer id){
        Optional<Task> optionalTask=taskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task task=optionalTask.get();
            task.setStatus(true);
            return taskRepository.save(task);
        }else{
            throw new RuntimeException("The task with "+id+" is not present");
        }
    }

    public Task updateTaskDefinition(Integer id,TaskUpdateRequest request) {
        Optional<Task> optionalTask=taskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task task=optionalTask.get();
            task.setTask(request.getTask());
            taskRepository.save(task);
            return task;
        }else{
            throw new RuntimeException("The task with id: "+id+"was not found");
        }
    }
}
