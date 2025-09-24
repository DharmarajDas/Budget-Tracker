import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BudgetTracker bt = new BudgetTracker();

        System.out.println("===== Welcome to Budget Tracker =====");
        System.out.print("Enter your monthly budget: ");
        double budget = readDouble(sc);
        bt.setMonthlyBudget(budget);
        System.out.println("✅ Monthly budget set to: " + budget);

        int choice;
        do {
            System.out.println("\n===== Budget Tracker Menu =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. Monthly Report");
            System.out.println("5. Show Balance");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = readInt(sc);

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter income amount: ");
                    double income = readDouble(sc);
                    String incCat = chooseCategory(sc, true);
                    System.out.print("Enter description: ");
                    String incDesc = sc.nextLine();
                    bt.addIncome(income, incCat, incDesc);
                }
                case 2 -> {
                    System.out.print("Enter expense amount: ");
                    double expense = readDouble(sc);
                    String expCat = chooseCategory(sc, false);
                    System.out.print("Enter description: ");
                    String expDesc = sc.nextLine();
                    bt.addExpense(expense, expCat, expDesc);
                }
                case 3 -> bt.printTransactions();
                case 4 -> bt.printMonthlyReport();
                case 5 -> System.out.println("💰 Current Balance: " + bt.getBalance());
                case 0 -> System.out.println("👋 Exiting... Goodbye!");
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("❌ Invalid input. Please enter a number: ");
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("❌ Invalid input. Please enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static String chooseCategory(Scanner sc, boolean isIncome) {
        String[] expenseCategories = {"Food", "Rent", "Shopping", "Travel", "Bills", "Other"};
        String[] incomeCategories = {"Salary", "Bonus", "Other"};
        String[] categories = isIncome ? incomeCategories : expenseCategories;

        System.out.println("Select Category:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        int choice;
        while (true) {
            System.out.print("Enter option: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
                if (choice >= 1 && choice <= categories.length) {
                    return categories[choice - 1];
                }
            } else {
                sc.next();
            }
            System.out.println("❌ Invalid option. Try again.");
        }
    }
}
