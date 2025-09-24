# Budget Tracker

![Java](https://img.shields.io/badge/Language-Java-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Last Commit](https://img.shields.io/github/last-commit/yourusername/Java-Budget-Tracker)
![Repo Size](https://img.shields.io/github/repo-size/yourusername/Java-Budget-Tracker)

A simple **Java-based Budget Tracker** that helps you manage your income and expenses, track spending by category, and maintain a monthly budget. All transactions are stored in a **text file in real-time**, ensuring no data is lost.

---

## Features

- Add **income** with category and description.  
- Add **expenses** with category and description.  
- Select **predefined categories** for income and expenses.  
- **Monthly budget warning** if expenses exceed the set budget.  
- **View all transactions** in a clean table format.  
- **Monthly report** showing total income, expenses, and net balance.  
- **Real-time logging**: all transactions are saved immediately in `transactions.txt`.  
- Clean and simple **console-based menu** for easy interaction.  

---

## Installation / How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/Java-Budget-Tracker.git
   
2. Open the project in your favorite IDE (Eclipse, IntelliJ, or VS Code).

3. Make sure you have Java 8 or above installed.

4. Compile and run Main.java:
   ```bash
   javac Main.java
   java Main
   
5. Follow the console menu to add income, expenses, or view reports.

---

## Usage

When the program starts, it will ask you to set your monthly budget.

Add income or expenses by choosing the menu options.

Every transaction will be saved immediately to transactions.txt.

The program will automatically show category-wise expense totals when adding expenses.

View all transactions or a monthly report anytime from the menu.

---

## Sample transactions.txt Format

Type     | Category  | Description         | Amount   | Date
Income   | Salary    | September Salary    | 10000.00 | 2025-09-23
Expense  | Food      | Pizza + Drinks      | 250.00   | 2025-09-23
Expense  | Travel    | Uber Ride           | 150.00   | 2025-09-23

---

## Future Improvements

GUI version using JavaFX or Swing for a more user-friendly interface.

Search and filter transactions by date or category.

Edit or delete transactions after adding.

Export to CSV or Excel for detailed reports.

Monthly savings goals and visual charts.

---

## Technology / Requirements

Language: Java

IDE: Eclipse, IntelliJ, VS Code, or any Java IDE

Java Version: 8 or above

File Storage: transactions.txt

---

## License

This project is open-source and free to use. You can modify it for personal use or learning purposes.


