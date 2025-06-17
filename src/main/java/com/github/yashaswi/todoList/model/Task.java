package com.github.yashaswi.todoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {
    @Id
    private Integer Id;

    @NotNull
    private String Task;

    private Boolean status;

    //ID
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    //Task
    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    //Status
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
