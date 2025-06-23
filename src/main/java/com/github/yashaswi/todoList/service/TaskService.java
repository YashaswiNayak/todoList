package com.github.yashaswi.todoList.service;

import com.github.yashaswi.todoList.dto.PriorityUpdateRequest;
import com.github.yashaswi.todoList.dto.TaskCreateRequest;
import com.github.yashaswi.todoList.dto.TaskUpdateRequest;
import com.github.yashaswi.todoList.exception.TaskNotFoundException;
import com.github.yashaswi.todoList.model.Priority;
import com.github.yashaswi.todoList.model.Task;
import com.github.yashaswi.todoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskCreateRequest request) {
        Task task = new Task();
        task.setTask(request.getTask());
        task.setStatus(request.getStatus());
        task.setDeleted(request.isDeleted());
        task.setDueDate(request.getDueDate());
        task.setPriority(request.getPriority());
        taskRepository.save(task);
        return task;
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findByDeletedFalse();
    }

    public void deleteTask(Integer id) {
        Task task = taskRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setDeleted(true);
        taskRepository.save(task);
        System.out.print("Task with id: " + id + " has been deleted");
    }

    public List<Task> getTaskByStatus(boolean status) {
        return taskRepository.findByStatusAndDeletedFalse(status);
    }

    public Task updateTaskStatus(Integer id) {
        Task task = taskRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setStatus(true);
        return taskRepository.save(task);
    }

    public Task updateTaskDefinition(Integer id, TaskUpdateRequest request) {
        Task task = taskRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setTask(request.getTask());
        taskRepository.save(task);
        return task;
    }

    public List<Task> searchForTasks(String keyword) {
        return taskRepository.findByTaskDefinitionContainingIgnoreCaseAndDeletedFalse(keyword);
    }

    public void restoreDeletedTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setDeleted(false);
        taskRepository.save(task);
    }


    public List<Task> getFilteredTasks(Boolean status, Boolean deleted, String due, Priority priority,String sortBy,String order) {
        List<Task> tasks = taskRepository.findByDeletedFalse(); // start with all active tasks

        if (status != null) {
            tasks = tasks.stream().filter(task -> task.getStatus().equals(status)).toList();
        }

        if (priority != null) {
            tasks = tasks.stream().filter(task -> task.getPriority().equals(priority)).toList();
        }

        if (due != null) {
            if (due.equalsIgnoreCase("overdue")) {
                tasks = tasks.stream().filter(task -> task.getDueDate().isBefore(LocalDate.now())).toList();
            } else if (due.equalsIgnoreCase("upcoming")) {
                tasks = tasks.stream().filter(task -> task.getDueDate().isAfter(LocalDate.now())).toList();
            }
        }

        if (deleted != null) {
            tasks = tasks.stream().filter(task -> task.getDeleted().equals(deleted)).toList();
        }
        Comparator<Task> comparator = switch (sortBy) {
            case "priority" -> Comparator.comparing(Task::getPriority);
            case "task" -> Comparator.comparing(Task::getTask);
            default -> Comparator.comparing(Task::getDueDate);
        };
        if(order.equalsIgnoreCase("desc")){
            comparator=comparator.reversed();
        }
        tasks=tasks.stream().sorted(comparator).toList();

        return tasks;
    }

    public void changePriority(Integer id, PriorityUpdateRequest priority) {
        Task task=taskRepository.findByIdAndDeletedFalse(id).orElseThrow(()->new TaskNotFoundException(id));
        task.setPriority(priority.getPriority());
        taskRepository.save(task);
    }
}
