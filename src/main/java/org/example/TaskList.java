// TaskLinkedList.java
package org.example;

import java.util.*;

public class TaskLinkedList {
    private final Map<String, User> users;

    public TaskLinkedList() {
        this.users = new HashMap<>();
    }

    public void addUser(String name) {
        if (users.containsKey(name)) {
            System.out.println("⚠️ User already exists.");
        } else {
            users.put(name, new User(name));
            System.out.println("✅ User '" + name + "' created.");
        }
    }

    public void addTaskToUser(String username, String taskDesc) {
        User user = users.get(username);
        if (user != null) {
            user.addTask(new Task(taskDesc));
            System.out.println("📌 Task added to " + username);
        } else {
            System.out.println("❌ User not found.");
        }
    }

    public void markUserTaskCompleted(String username, String taskDesc) {
        User user = users.get(username);
        if (user != null) {
            boolean success = user.markTaskCompleted(taskDesc);
            if (success) {
                System.out.println("✅ Task marked as completed.");
            } else {
                System.out.println("❌ Task not found.");
            }
        } else {
            System.out.println("❌ User not found.");
        }
    }

    public void viewUserTasks(String username) {
        User user = users.get(username);
        if (user != null) {
            List<Task> tasks = user.getTasks();
            if (tasks.isEmpty()) {
                System.out.println("⚠️ No tasks found.");
            } else {
                int i = 1;
                for (Task task : tasks) {
                    String status = task.isCompleted() ? "✅ Completed" : "❌ Not Completed";
                    System.out.println(i++ + ". " + task.getDescription() + " - " + status);
                }
            }
        } else {
            System.out.println("❌ User not found.");
        }
    }
}
