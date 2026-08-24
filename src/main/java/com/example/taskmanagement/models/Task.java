package com.example.taskmanagement.models;

public class Task {
    private long id;
    private String title;
    private String description;
    private String priority;
    private long assignedTo;

    public Task() {
    }

    public Task(long id, String title, String description, String priority, long assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignedTo = assignedTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }
}
