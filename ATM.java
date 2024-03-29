import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful. New balance: ₹" + balance);
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: ₹" + balance);
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

public class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void displayMenu() {
        System.out.println("Welcome to the ATM.");
        System.out.println("1. Check Balance.");
        System.out.println("2. Deposit.");
        System.out.println("3. withdraw.");
        System.out.println("4. Exit.");
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
         do{
             displayMenu();
             System.out.println("Enter Your Choice: ");
             choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     System.out.println("Your Balance is: Rs " + account.getBalance());
                     break;
                 case 2:
                     System.out.println("Enter deposit amount (Rs): ");
                     double depositAmount = scanner.nextDouble();
                     account.deposit(depositAmount);
                     break;
                 case 3:
                     System.out.println("Enter withdrawal amount (Rs): ");
                     double withdrawAmount = scanner.nextDouble();
                     if(account.withdraw(withdrawAmount)) {
                         System.out.println("Please take your Cash.");
                     }
                     break;
                 case 4:
                     System.out.println("Thank you for using the ATM.");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         } while (choice != 4);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}