/*
1. Add a new task [X]
2. Remove an existing task [X]
3. View all tasks [X]
4. Mark task as completed [X]
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // store task id in array list
        ArrayList<Task> tasks = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            System.out.println("Please choose a command (1. Add a new task, 2. Remove an existing task, " +
                    "3. View all tasks, 4. Marks task as completed, 5. Exit)");
            int command = 0;
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e ){
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }

            switch (command) {
                case 1:
                    System.out.println("---ADD NEW TASK---");

                    System.out.println("Please enter the title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();

                    System.out.println("Please enter the description: ");
                    String description = scanner.nextLine();

                    Task task = new Task(tasks.size() + 1, title, description, false);
                    // automatically increment id after created

                    // add task into arrayList of tasks
                    tasks.add(task);
                    System.out.println("---TASK CREATED---");
                    break;
                case 2:
                    System.out.println("---DELETE TASK---");
                    // print all tasks before deleting
                    Task.displayAllTasks(tasks);

                    if (!tasks.isEmpty()) {
                        //choose id to delete task
                        System.out.println("Enter task id:");
                        int id = scanner.nextInt();

                        try {
                            tasks.remove(id - 1);
                            System.out.println("---TASK DELETED---");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Task not found");
                        }
                    } else {
                        System.out.println("No task available");
                    }

                    Task.updateTaskIds(tasks);

                    break;
                case 3:
                    System.out.println("---VIEW ALL TASK---");
                    // print all task
                    Task.displayAllTasks(tasks);
                    break;
                case 4:
                    System.out.println("---MARK TASK AS COMPLETED---");

                    //print all ask
                    Task.displayAllTasks(tasks);

                    if (!tasks.isEmpty()) {
                        //choose id to delete task
                        System.out.println("Enter task id:");
                        int id = scanner.nextInt();

                        try {
                            tasks.get(id - 1).setIsCompleted(true);
                            System.out.println("---TASK MARKED AS COMPLETED---");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Task not found");
                        }
                    } else {
                        System.out.println("No task available");
                    }

                    break;
                case 5:
                    System.out.println("---BYE---");
                    flag = false;
                    break;
            }
        }

        scanner.close();
    }
}