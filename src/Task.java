public class Task {

    /*  make fiields private (encapsulation) prevents external code
    from mutating fields directly */
    private String description;

    // whether the task is completed. Primitive boolean avoids nulls and boxing
    private boolean isCompleted;

    // Full constructor. 
    public Task(String description, boolean isCompleted) {
        this.description = description; // task text
        this.isCompleted = isCompleted; // initial completed state
    }

    // common case: tasks start incomplete
    // delegates to full constructor with isCompleted = false.
    public Task(String description) {
        this(description, false);
    }

    /* Getter for description.
        Returns current description string so callers can read it.
     */
    public String getDescription() {
        return description; 
    }

    /* Setter for description.
        Use this to update the task text
        @param description new description to set */
    public void setDescription(String description) {
        this.description = description;
    }

    /* boolean getter for completion status. 
        Named using JavaBean convention isCompleted() so calls read naturally.
        returns primitive boolean */
    public boolean isCompleted() {
        return isCompleted;
    }

    /* Setter for completion status.
        This method mutates the task's internal state; it returns void because it performs an action.
        change state rather than producing value. */
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    /* centralizes display logic so we don't need to format task each time we print */
    @Override
    public String toString() {
        return (isCompleted ? "[x] " : "[ ] ") + description;
        
    }
    



}

