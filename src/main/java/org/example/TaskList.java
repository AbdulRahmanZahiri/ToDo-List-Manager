package org.example;

import org.example.linkedlist.SingleLinkedList;

public class TaskList {
    private final SingleLinkedList<Task> tasks;

    public TaskList() {
        this.tasks = new SingleLinkedList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public SingleLinkedList<Task> getAllTasks() {
        return tasks;
    }

    public boolean markTaskCompleted(String desc) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(desc)) {
                task.setCompleted(true);
                return true;
            }
        }
        return false;
    }
}
