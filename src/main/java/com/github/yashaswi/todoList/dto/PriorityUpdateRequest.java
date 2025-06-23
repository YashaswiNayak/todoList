package com.github.yashaswi.todoList.dto;

import com.github.yashaswi.todoList.model.Priority;

public class PriorityUpdateRequest {
    private Priority priority;
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
