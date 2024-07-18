package YashM;
import java.util.Scanner;

class ATM {
    private BankAcc bankAccount;
    private Scanner scanner;

    public ATM(BankAcc bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    double balance = bankAccount.checkBalance();
                    System.out.println("Your balance is: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }
}

class BankAcc {
    private String accountHolder;
    private double balance;

    public BankAcc(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("$" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
public class ATM_Interface {
    private static String[] accountHolders = {"Yash M", "Jayash"};
    private static double[] balances = {1000, 150};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        int accountIndex = -1;
        for (int i = 0; i < accountHolders.length; i++) {
            if (accountHolders[i].equals(name)) {
                accountIndex = i;
                break;
            }
        }
        if (accountIndex != -1) {
            BankAcc account = new BankAcc(accountHolders[accountIndex], balances[accountIndex]);
            ATM atm = new ATM(account);
            atm.run();
        } else {
            System.out.println("Account holder name not found.");
        }
        scanner.close();
    }
}