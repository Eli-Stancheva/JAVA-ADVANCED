package ADVANCED.LAB_6_Defining_Classes.P3_BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int accountCount = 0;

    public BankAccount() {
        accountCount++;
        this.id = accountCount;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double money){
        this.balance += money;
    }

    public double getInterest (int years){
        return years * interestRate * this.balance;
    }
}
