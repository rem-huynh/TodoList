import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // setup scanner for user input
        ArrayList<Task> tasks = new ArrayList<>();
        boolean running = true;

        // switch-cases for menu options 
        while (running) {
            int choice = displayMenu(sc); 
            switch (choice) {
                case 1:
                    addTask(sc, tasks);
                    break; 
                // case 2: (implement once viewTask logic is ready)
                case 2: 
                    viewTasks(tasks);
                    break;
                case 3: 
                    taskComplete(sc, tasks);
                    break;
                case 4: 
                    deleteTask(sc, tasks);
                    break;
                case 5:
                    running = false;
                    break;

            }
        }

    }
    // static helper to display the menu options
    static int displayMenu(Scanner sc) {
        System.out.println("Welcome to Remys Todo List App.");
        System.out.println("1) Add Task");
        System.out.println("2) View Tasks");
        System.out.println("3) Mark Task Complete");
        System.out.println("4) Delete Task"); 
        System.out.println("5) Exit Todo List"); 
        System.out.println("Please Select an option from the menu to proceed: ");


        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input, a number from 1-5");
            sc.next(); // discard invalid token
        }
        int choice = sc.nextInt();
        sc.nextLine(); // consume the leftover newline from nextInt() so a subsequent 
                       // nextLine() reads user input instead of an empty line
        return choice;
    }


    static void addTask(Scanner sc, ArrayList<Task> tasks) {
        boolean validInput = false; // create local boolean variable to control do-while loop
        do {
            System.out.println("Enter new task description: "); // message for user to input task description
            String taskDescription = sc.nextLine(); // prompt user for input
            
            // if input is not valid (empty/whitespace) re-prompt user for valid input.
            if (taskDescription.trim().isEmpty()) {
                System.out.println("Invalid input, please enter task description: ");
            } else { 
                // if input is valid, set validInput to true
                validInput = true;
                
                // create new task + add to tasks<> array
                Task newTask = new Task (taskDescription); // create new task instance 
                tasks.add(newTask); 
                System.out.println("Task added: " + newTask); // confirm with user task has been added
            } 
        } while (!validInput); // do-while loop executes as long as validInput = false
        // loop will exit if valid input is given, create new task      
    }

    // helper method to view current tasks
    static void viewTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available.");
        } else { 
            System.out.println("--- Current Tasks ---");

            // use traditional for loop to get tasks index number and print accordingly
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) +  ") " + tasks.get(i));
            }
        }
    }

    // helper method to handle task completion marking
    static void taskComplete(Scanner sc, ArrayList<Task> tasks) {
        
        int listSize = tasks.size();
        int choice;

        // conditional that checks if there are any tasks to complete before prompting for user input.
        if (tasks.isEmpty()) {
            System.out.println("No tasks available! ");
            return;
        }
        
        // prompt user to choose a task, input has to be within size of arraylist
        do {
            System.out.println("Choose a task to complete (1 to  " + listSize + "): ");
            choice = sc.nextInt(); // prompt user input and stores it into "choice" variable


            // if user inptu is below zero, or greater than task list size: print error and reprompt.
            if (choice < 1 || choice > listSize) { 
                System.out.println("Error: Invalid index, Please choose a valid task.");
                sc.nextLine();
            } 
        } while (choice < 1 || choice > listSize); // keep looping this until user input is within range of the list size


        Task selectedTask = tasks.get(choice - 1);
        selectedTask.setCompleted(true);
        System.out.println("Task marked as completed." + selectedTask);
    }

    static void deleteTask(Scanner sc, ArrayList<Task> tasks) {
        int listSize = tasks.size();
        int choice;

        // conditional that checks if there are any tasks to delete before prompting for user input. 
        if (tasks.isEmpty()) {
            System.out.println("No tasks available! ");
            return;
        }

        // Prompt user for input in a loop that executes as long as the input is invalid.
        do {
            System.out.println("Choose a task to delete (1 to " + listSize + "): ");
            choice = sc.nextInt();

            if (choice < 1 || choice > listSize) {
                System.out.println("Error: Invalid index, please choose a valid task.");
                sc.nextLine();
            }
        } while (choice < 1 || choice > listSize);
        sc.nextLine();

        Task selectedTask = tasks.get(choice - 1);


        System.out.println("Are you sure? yes/no");
        String confirmDelete = sc.nextLine();

        // confirms with user if they want to delete, prevents accidental-deletion
        if (confirmDelete.equalsIgnoreCase("yes")) {
            tasks.remove(selectedTask);
            System.out.println("Task has been removed. " + selectedTask);
        } else if (confirmDelete.equalsIgnoreCase("no")) {
            System.out.println("Task was not removed. " + selectedTask);
            return;
        }
    }


}


