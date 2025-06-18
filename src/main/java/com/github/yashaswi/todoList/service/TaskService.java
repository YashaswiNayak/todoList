package com.github.yashaswi.todoList.service;

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

    public Task createTask(String taskDescription) {
        Task task=new Task();
        task.setTask(taskDescription);
        task.setStatus(Boolean.FALSE);
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
}
