import java.time.LocalDate;

public class Transaction {
    private double amount;
    private String category;
    private String description;
    private LocalDate date;
    private boolean isIncome;

    public Transaction(double amount, String category, String description, LocalDate date, boolean isIncome) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.isIncome = isIncome;
    }

    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }
    public boolean isIncome() { return isIncome; }

    @Override
    public String toString() {
        String type = isIncome ? "Income" : "Expense";
        return String.format("%-8s | %-12s | %-20s | %10.2f | %s",
                type, category, description, amount, date);
    }
}
