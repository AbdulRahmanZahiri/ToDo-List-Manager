package org.example;

/**
 * Represents a task in a user's to-do list.
 * Each task has a description and a completion status.
 */
public class Task {
    private String description; // Description of the task
    private boolean completed;  // Status: true if completed, false otherwise

    /**
     * Constructor to create a new task with a given description.
     * By default, the task is marked as not completed.
     */
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    /**
     * Gets the description of the task.
     *
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the task.
     *
     * @param completed true to mark as completed, false otherwise
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
