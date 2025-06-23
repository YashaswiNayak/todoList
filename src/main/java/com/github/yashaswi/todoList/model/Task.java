package com.github.yashaswi.todoList.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

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

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

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

    //Deleted
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
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
