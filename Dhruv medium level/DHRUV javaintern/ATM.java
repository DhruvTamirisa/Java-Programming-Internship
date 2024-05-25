import java.util.Scanner;

public class ColourfulATMSimulator {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 10000; // Initial balance, you can set this to any desired value

    public static void main(String[] args) {
        System.out.println("Welcome to the Colourful ATM Simulator");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash();
                    break;
                case 3:
                    depositCash();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    System.out.println("Thank you for using Colourful ATM Simulator!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void withdrawCash() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            System.out.println("Remaining balance: $" + balance);
        }
    }

    private static void depositCash() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
            System.out.println("New balance: $" + balance);
        }
    }

    private static void transferFunds() {
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.print("Enter the recipient's account number: ");
            String accountNumber = scanner.next();
            // Here you would implement the logic for transferring funds to another account
            System.out.println("$" + amount + " transferred successfully to account number " + accountNumber);
            balance -= amount;
            System.out.println("Remaining balance: $" + balance);
        }
    }
}
