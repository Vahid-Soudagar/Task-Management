/**
 * The Task class represents a task with a name, description, and due date.
 * The Task class represents a task entity and contains attributes for the name, description, and due date. 
 * It includes constructors to initializethese attributes, getter and setter methods to access and modify them, and no additional methods o 
 * behaviors. 
 * This class is used for storing information about tasks in a task management system.
 */
public class Task {
    private String name;         // Name of the task
    private String description;  // Description of the task
    private String dueDate;      // Due date for the task

    /**
     * Constructs a Task with the specified name, description, and due date.
     * @param name The name of the task.
     * @param description The description of the task.
     * @param dueDate The due date for the task.
     */
    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    /**
     * Default constructor for the Task class.
     */
    public Task() {
    }

    /**
     * Get the name of the task.
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the task.
     * @param name The name of the task.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the task.
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the task.
     * @param description The description of the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the due date for the task.
     * @return The due date for the task.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Set the due date for the task.
     * @param dueDate The due date for the task.
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
