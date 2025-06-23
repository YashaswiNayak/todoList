package com.github.yashaswi.todoList.dto;

import com.github.yashaswi.todoList.model.Priority;

import java.time.LocalDate;

public class TaskCreateRequest {

    private String task;
    private Boolean status;
    private Boolean deleted;
    private LocalDate dueDate;
    private Priority priority;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

}
