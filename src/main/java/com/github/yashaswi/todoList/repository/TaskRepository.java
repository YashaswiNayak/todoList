package com.github.yashaswi.todoList.repository;

import com.github.yashaswi.todoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(Boolean status);
}
