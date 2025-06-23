package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, User> users = new HashMap<>();

        while (true) {
            System.out.println("\n === TO-DO LIST MANAGER === ");
            System.out.println("1:  Create user");
            System.out.println("2:  Add task to user");
            System.out.println("3:  Mark task as completed");
            System.out.println("4:  View tasks for user");
            System.out.println("5:  Exit");
            System.out.print("  Enter your choice:  ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print(" Enter user name: ");
                    String userName = scanner.nextLine();
                    if (users.containsKey(userName)) {
                        System.out.println(" User already exists.");
                    } else {
                        users.put(userName, new User(userName));
                        System.out.println(" User created.");
                    }
                }
                case 2 -> {
                    System.out.print(" Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print(" Enter task description: ");
                    String desc = scanner.nextLine();
                    User user = users.get(name);
                    if (user != null) {
                        user.addTask(new Task(desc));
                        System.out.println(" Task added.");
                    } else {
                        System.out.println(" User not found.");
                    }
                }
                case 3 -> {
                    System.out.print(" Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print(" Enter task to complete: ");
                    String desc = scanner.nextLine();
                    User user = users.get(name);
                    if (user != null && user.markTaskCompleted(desc)) {
                        System.out.println(" Task marked as completed.");
                    } else {
                        System.out.println(" Task or user not found.");
                    }
                }
                case 4 -> {
                    System.out.print(" Enter user name: ");
                    String name = scanner.nextLine();
                    User user = users.get(name);
                    if (user != null) {
                        int i = 1;
                        for (Task task : user.getTaskList().getAllTasks()) {
                            String status = task.isCompleted() ? " Completed" : " Not Completed";
                            System.out.println(i++ + ". " + task.getDescription() + " - " + status);
                        }
                    } else {
                        System.out.println(" User not found.");
                    }
                }
                case 5 -> {
                    System.out.println(" Goodbye!");
                    return;
                }
                default -> System.out.println("️ Invalid choice.");
            }
        }
    }
}
