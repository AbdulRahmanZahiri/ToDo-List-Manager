package org.example;

public class User {
    private final String name;
    private final TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        taskList.addTask(task);
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public boolean markTaskCompleted(String desc) {
        return taskList.markTaskCompleted(desc);
    }
}
