import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The TaskManagement class manages a list of tasks and provides methods to add, remove, list, and validate tasks.
 * The TaskManagement class manages a list of tasks and provides methods for adding, removing, listing, and validating tasks. 
 * It includes methods for checking the validity of task names, descriptions, and due dates, as well as methods for ensuring that tasks with the
 * same name are not added. 
 * It uses the Task class to represent individual tasks and stores them in a list.
 */
public class TaskManagement {

    private List<Task> taskList;

    /**
     * Constructs a TaskManagement instance with an empty list of tasks.
     */
    public TaskManagement() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     * @param task The task to be added.
     */
    public void add(Task task){
        if (task == null) {
            System.out.println("Task is not valid");
            return;
        }
        taskList.add(task);
    }

    /**
     * Removes a task by name from the task list.
     * @param name The name of the task to be removed.
     */
    public void remove(String name) {
        if (taskList.isEmpty()) {
            System.out.println("No Task found! unable to delete the task");
        } else {
            Iterator<Task> iterator = taskList.iterator();
            while(iterator.hasNext()) {
                Task t = iterator.next();
                if (t.getName().equals(name)) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Lists the details of tasks in the task list.
     */
    public void listTask() {
        if (taskList.size() == 0) {
            System.out.println("No Task Found! Please add tasks first");
        } else {
            System.out.println("******************************************");
            for (Task t : taskList) {
                System.out.println("Name: "+t.getName()+"\nDescription: "+t.getDescription()+"\nDue Date: "+t.getDueDate());
            }
            System.out.println("*********************************************");
        }
    }

    /**
     * Validates the task by checking if the name, description, and date are not empty and the date is valid.
     * @param name The name of the task.
     * @param des The description of the task.
     * @param date The due date of the task.
     * @return True if the task is valid, false otherwise.
     */
    public boolean isValidTask(String name, String des, String date) {
        if (name.isEmpty()) {
            System.out.println("Name is Empty");
            return false;
        } else if (des.isEmpty()) {
            System.out.println("Description is Empty");
            return false;
        } else if (date.isEmpty() || !isValidDate(date)) {
            System.out.println("Date is invalid");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates a date by checking if it's in a valid format and not in the past.
     * @param date The date to be validated.
     * @return True if the date is valid, false otherwise.
     */
    public boolean isValidDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date inputDate = dateFormat.parse(date);
            Date currentDate = new Date();

            // Compare the input date with the current date
            if (inputDate.compareTo(currentDate) >= 0) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(inputDate);

                // Check for valid day, month, and year
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH) + 1; // Month is 0-based
                int year = cal.get(Calendar.YEAR);

                if (isValidDay(day) && isValidMonth(month) && isValidYear(year)) {
                    return true; // Input date is valid
                }
            }
        } catch (ParseException e) {
            // Invalid date format
        }
        return false; // Invalid date
    }

    private boolean isValidDay(int day) {
        return day >= 1 && day <= 31; // Adjust the range as needed
    }

    private boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private boolean isValidYear(int year) {
        return year >= 1900 && year <= 2100; // Adjust the range as needed
    }

    /**
     * Checks if a task with the given name already exists in the task list.
     * @param name The name to check for existence.
     * @return True if a task with the same name exists, false otherwise.
     */
    public boolean isTaskAlreadyExists(String name) {
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                return true; // A task with the same name exists
            }
        }
        return false; // No task with the same name found
    }
}
