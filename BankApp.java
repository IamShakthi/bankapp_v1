import java.util.*;

public class BankApp {
    static Scanner sc = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();
    static int accountCounter = 1001;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🌟 Welcome to Sakthi Bank 🌟");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> loginAccount();
                case 3 -> {
                    System.out.println("Thank you for using Sakthi Bank!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter your name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();

        System.out.print("Set a 4-digit PIN: ");
        String pin = sc.next();

        Account acc = new Account(name, accountCounter++, pin);
        accounts.add(acc);
        System.out.println("Account created! Your Account Number is: " + acc.getAccountNumber());
    }

    static void loginAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter PIN: ");
        String pin = sc.next();

        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo && acc.verifyPin(pin)) {
                System.out.println("Welcome, " + acc.getName() + "!");
                accountMenu(acc);
                return;
            }
        }
        System.out.println("Invalid account number or PIN.");
    }

    static void accountMenu(Account acc) {
        while (true) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amt = sc.nextDouble();
                    acc.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    acc.withdraw(amt);
                }
                case 3 -> acc.checkBalance();
                case 4 -> {
                    System.out.println("Logged out.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
