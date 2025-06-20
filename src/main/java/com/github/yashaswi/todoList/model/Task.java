package com.github.yashaswi.todoList.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @Column(name = "taskDefinition")
    private String taskDefinition;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "deleted")
    private Boolean deleted;

    //ID
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    //Task
    public String getTask() {
        return taskDefinition;
    }

    public void setTask(String task) {
        this.taskDefinition = task;
    }

    //Status
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
