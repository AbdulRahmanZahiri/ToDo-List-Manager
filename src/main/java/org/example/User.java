package org.example;

/**
 * Represents a user in the to-do list system.
 * Each user has a name and their own task list.
 */
public class User {
    private final String name;       // Name of the user (unique)
    private final TaskList taskList; // Task list associated with the user

    /**
     * Constructor to create a new user with an empty task list.
     *
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    /**
     * Gets the name of the user.
     *
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a task to the user's task list.
     *
     * @param task the task to be added
     */
    public void addTask(Task task) {
        taskList.addTask(task);
    }

    /**
     * Gets the user's task list.
     *
     * @return the TaskList object
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * Marks a task as completed by its description.
     *
     * @param desc the description of the task to mark
     * @return true if the task was found and marked, false otherwise
     */
    public boolean markTaskCompleted(String desc) {
        return taskList.markTaskCompleted(desc);
    }

    /**
     * Removes a task from the user's task list by description.
     *
     * @param desc the description of the task to remove
     * @return true if the task was found and removed, false otherwise
     */
    public boolean removeTask(String desc) {
        return taskList.removeTask(desc);
    }

}
