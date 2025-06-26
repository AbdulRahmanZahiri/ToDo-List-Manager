package org.example;

import java.util.Scanner;

/**
 * Main class for the To-Do List Manager using an array for user storage.
 * This CLI application allows users to:
 * - Create user accounts
 * - Add tasks to each user
 * - Mark tasks as completed
 * - View a user's task list
 */
public class Main {
    private static final int MAX_USERS = 100; // Maximum number of users the system can hold
    private static User[] users = new User[MAX_USERS]; // Array to store User objects
    private static int userCount = 0; // Tracks the number of users added

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner to read user input

        while (true) {
            // Display the main menu
            System.out.println("\n=== TO-DO LIST MANAGER ===");
            System.out.println("1: Create user");
            System.out.println("2: Add task to user");
            System.out.println("3: Mark task as completed");
            System.out.println("4: View tasks for user");
            System.out.println("5: Remove user");
            System.out.println("6: Remove task from user");
            System.out.println("7: Exit");

            System.out.print("Enter your choice: ");

            // Read user input
            int choice = Integer.parseInt(scanner.nextLine());

            // Perform the selected operation
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    if (findUser(userName) != null) {
                        System.out.println("User already exists.");
                    } else if (userCount < MAX_USERS) {
                        users[userCount++] = new User(userName);
                        System.out.println("User created.");
                    } else {
                        System.out.println("User limit reached.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    User user = findUser(name);
                    if (user != null) {
                        user.addTask(new Task(desc));
                        System.out.println("Task added.");
                    } else {
                        System.out.println("User not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task to complete: ");
                    String desc = scanner.nextLine();
                    User user = findUser(name);
                    if (user != null && user.markTaskCompleted(desc)) {
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Task or user not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    User user = findUser(name);
                    if (user != null) {
                        if (user.getTaskList().getAllTasks().isEmpty()) {
                            System.out.println("No tasks found for this user.");
                        } else {
                            int i = 1;
                            for (Task task : user.getTaskList().getAllTasks()) {
                                String status = task.isCompleted() ? "Completed" : "Not Completed";
                                System.out.println(i++ + ". " + task.getDescription() + " - " + status);
                            }
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                }

                case 5 -> {
                    System.out.print("Enter user name to remove: ");
                    String name = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].getName().equals(name)) {
                            // Shift users left
                            for (int j = i; j < userCount - 1; j++) {
                                users[j] = users[j + 1];
                            }
                            users[--userCount] = null;
                            found = true;
                            System.out.println("User removed.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("User not found.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task description to remove: ");
                    String desc = scanner.nextLine();
                    User user = findUser(name);
                    if (user != null && user.removeTask(desc)) {
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Task or user not found.");
                    }
                }
                case 7 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("️ Invalid choice.");
            }
        }
    }

    /**
     * Helper method to find a user in the array by username.
     *
     * @param userName The name of the user to find
     * @return The User object if found, otherwise null
     */
    private static User findUser(String userName) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(userName)) {
                return users[i];
            }
        }
        return null;
    }
}
