import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class BudgetTracker {
    private ArrayList<Transaction> transactions;
    private double balance;
    private double monthlyBudget;
    private String filename = "transactions.txt"; // default file
    public BudgetTracker() {
        transactions = new ArrayList<>();
        balance = 0;
        monthlyBudget = 0;
        // Create file header if file does not exist
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            // Only add header if file is empty
            if (new java.io.File(filename).length() == 0) {
                writer.println("Type     | Category  | Description         | Amount   | Date");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMonthlyBudget(double budget) {
        this.monthlyBudget = budget;
    }

    public void addIncome(double amount, String category, String description) {
        Transaction income = new Transaction(amount, category, description, LocalDate.now(), true);
        transactions.add(income);
        balance += amount;
        appendTransactionToFile(income);
    }

    public void addExpense(double amount, String category, String description) {
        Transaction expense = new Transaction(amount, category, description, LocalDate.now(), false);
        transactions.add(expense);
        balance -= amount;

        appendTransactionToFile(expense);

        // Show category expense summary automatically
        double totalInCategory = transactions.stream()
                .filter(t -> !t.isIncome() && t.getCategory().equals(category)
                        && t.getDate().getMonth() == LocalDate.now().getMonth())
                .mapToDouble(Transaction::getAmount)
                .sum();
        System.out.printf("✅ Expense added under category: %s%n", category);
        System.out.printf("Total spent on %s this month: %.2f%n", category, totalInCategory);

        if (monthlyBudget > 0 && getTotalExpensesThisMonth() > monthlyBudget) {
            System.out.println("⚠️ Warning: You exceeded your monthly budget!");
        }
    }

    private void appendTransactionToFile(Transaction t) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.printf("%-8s | %-10s | %-20s | %-8.2f | %s%n",
                    t.isIncome() ? "Income" : "Expense",
                    t.getCategory(),
                    t.getDescription(),
                    t.getAmount(),
                    t.getDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double getTotalExpensesThisMonth() {
        LocalDate now = LocalDate.now();
        return transactions.stream()
                .filter(t -> !t.isIncome() && t.getDate().getMonth() == now.getMonth())
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public void printTransactions() {
        System.out.println("\n===== All Transactions =====");
        System.out.printf("%-8s | %-12s | %-20s | %-10s | %-12s%n",
                "Type", "Category", "Description", "Amount", "Date");
        System.out.println("--------------------------------------------------------------------------");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void printMonthlyReport() {
        LocalDate now = LocalDate.now();
        double totalIncome = 0, totalExpense = 0;
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == now.getMonth()) {
                if (t.isIncome()) totalIncome += t.getAmount();
                else totalExpense += t.getAmount();
            }
        }
        System.out.println("\n===== Monthly Report (" + now.getMonth() + ") =====");
        System.out.printf("Total Income   : %.2f%n", totalIncome);
        System.out.printf("Total Expense  : %.2f%n", totalExpense);
        System.out.printf("Net Balance    : %.2f%n", totalIncome - totalExpense);
    }

    public double getBalance() {
        return balance;
    }
}
