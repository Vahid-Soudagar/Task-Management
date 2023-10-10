import java.util.Scanner;

/**
 * The TaskDemo class provides a command-line interface for task management.
 * The TaskDemo class serves as a command-line interface for task management. 
 * It allows users to add, remove, and list tasks. 
 * Users can enter task details such as name, description, and due date, and the program validates the input to ensure tasks are correctly 
 * formatted. 
 * The program uses the TaskManagement class to handle task operations and keeps running until the user chooses to exit.
 */

public class TaskDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("**********************************Welcome to Task Management******************************************");
        TaskManagement taskManagement = new TaskManagement();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Task");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.print("Enter task name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter task description: ");
                        String description = sc.nextLine();
                        System.out.print("Enter due date (dd/mm/yyyy): ");
                        String dueDate = sc.nextLine();
                        
                        if (taskManagement.isTaskAlreadyExists(name)) {
                            System.out.println("A task with the same name already exists. Please choose a different name.");
                        } else if (taskManagement.isValidTask(name, description, dueDate)) {
                            Task t = new Task();
                            t.setName(name);
                            t.setDescription(description);
                            t.setDueDate(dueDate);
                            taskManagement.add(t);
                            break;
                        } else {
                            System.out.println("Invalid task. Please correct the issues:");
                        }
                    }
                break;

                case 2:
                    System.out.print("Enter task name: ");
                    String remName = sc.nextLine();
                    taskManagement.remove(remName);
                break;

                case 3:
                taskManagement.listTask();
                break;

                case 4:
                exit = true;
                break;

                default:
                System.out.println("Invalid input");
            }

        }
        System.out.println("******************************************************************************************************");
        sc.close();
    }
}
