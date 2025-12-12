import java.time.LocalDate;

public class Expense {
    private double amount;
    private int id;
    private LocalDate date;
    private String description;
    private String category;
    

    // expense object constructor
    public Expense(double amount, int id, String description, LocalDate date, String category) {
        this.amount = amount; 
        this.id = id;
        this.description = description; 
        this.date = date;
        this.category = category;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    } 
    

}
