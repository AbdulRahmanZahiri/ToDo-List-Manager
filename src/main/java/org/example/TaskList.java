package org.example;

import org.example.linkedlist.SingleLinkedList;

/**
 * Manages a list of tasks for a user using a custom singly linked list.
 * Provides methods to add tasks, retrieve all tasks, and mark tasks as completed.
 */
public class TaskList {
    private final SingleLinkedList<Task> tasks; // Linked list to store tasks

    /**
     * Initializes an empty task list.
     */
    public TaskList() {
        this.tasks = new SingleLinkedList<>();
    }

    /**
     * Adds a new task to the task list.
     *
     * @param task the task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the entire list of tasks.
     *
     * @return the task list
     */
    public SingleLinkedList<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Marks the first task matching the given description as completed.
     *
     * @param desc the description of the task to mark
     * @return true if the task was found and marked, false otherwise
     */
    public boolean markTaskCompleted(String desc) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(desc)) {
                task.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the first task matching the given description.
     *
     * @param desc the description of the task to remove
     * @return true if the task was found and removed, false otherwise
     */
    public boolean removeTask(String desc) {
        return tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(desc));
    }




}
