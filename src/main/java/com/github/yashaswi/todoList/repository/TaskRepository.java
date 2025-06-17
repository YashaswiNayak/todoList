package com.github.yashaswi.todoList.repository;

import com.github.yashaswi.todoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class TaskRepository implements JpaRepository<Task, Integer> {
}
