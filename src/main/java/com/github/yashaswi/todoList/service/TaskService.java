package com.github.yashaswi.todoList.service;

import com.github.yashaswi.todoList.dto.TaskCreateRequest;
import com.github.yashaswi.todoList.dto.TaskUpdateRequest;
import com.github.yashaswi.todoList.exception.TaskNotFoundException;
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
        task.setDeleted(request.isDeleted());
        taskRepository.save(task);
        return task;
    }

    public Task getTaskById(Integer id){
        return taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
    }

    public List<Task> getAllTasks(){
        return taskRepository.findByDeletedFalse();
    }

    public void deleteTask(Integer id) {
        Task task=taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
        task.setDeleted(true);
        taskRepository.save(task);
        System.out.print("Task with id: "+id+" has been deleted");
    }

    public List<Task> getTaskByStatus(boolean status) {
        return taskRepository.findByStatusAndDeletedFalse(status);
    }

    public Task updateTaskStatus(Integer id){
        Task task=taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
            task.setStatus(true);
            return taskRepository.save(task);
    }

    public Task updateTaskDefinition(Integer id,TaskUpdateRequest request) {
            Task task=taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
            task.setTask(request.getTask());
            taskRepository.save(task);
            return task;
    }

    public List<Task> searchForTasks(String keyword){
        return taskRepository.findByTaskDefinitionContainingIgnoreCaseAndDeletedFalse(keyword);
    }

    public List<Task> getDeletedTasks(Boolean deleted) {
        return taskRepository.findByDeleted(deleted);
    }

    public void restoreDeletedTask(Integer id) {
        Task task=taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
        task.setDeleted(false);
        taskRepository.save(task);
    }
}
