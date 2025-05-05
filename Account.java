public class Account {
    private String name;
    private int accountNumber;
    private String pin;
    private double balance;

    public Account(String name, int accountNumber, String pin) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public boolean verifyPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}
