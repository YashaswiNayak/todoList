package com.github.yashaswi.todoList.repository;

import com.github.yashaswi.todoList.model.Priority;
import com.github.yashaswi.todoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByDeletedFalse();
    List<Task> findByPriorityAndDeletedFalse(Priority priority);
    List<Task> findByDueDateBeforeAndDeletedFalse(LocalDate dueDate);
    List<Task> findByDueDateAfterAndDeletedFalse(LocalDate dueDate);
    List<Task> findByDeleted(Boolean deleted);
    List<Task> findByStatusAndDeletedFalse(Boolean status);
    List<Task> findByTaskDefinitionContainingIgnoreCaseAndDeletedFalse(String keyword);
}
