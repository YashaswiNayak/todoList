package com.github.yashaswi.todoList.dto;

public class TaskCreateRequest {

    private String task;
    private Boolean status;
    private Boolean deleted;

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

}
