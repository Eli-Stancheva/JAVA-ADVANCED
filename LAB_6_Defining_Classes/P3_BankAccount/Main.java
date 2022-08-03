package ADVANCED.LAB_6_Defining_Classes.P3_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String command = line[0];
        while (!command.equals("End")) {
            String result = "";

            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    result = String.format("Account ID%d created", account.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(line[1]);
                    double amount = Double.parseDouble(line[2]);

                    if (accounts.containsKey(id)) {
                        BankAccount accountFromMap = accounts.get(id);
                        accountFromMap.deposit(amount);
                        accounts.put(id, accountFromMap);
                        result = String.format("Deposited %.0f to ID%d", amount, id);
                    } else {
                        result = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(line[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int idAccount = Integer.parseInt(line[1]);
                    int years = Integer.parseInt(line[2]);
                    if (accounts.containsKey(idAccount)) {
                        BankAccount bankAccount = accounts.get(idAccount);
                        double totalInterest = bankAccount.getInterest(years);
                        result = String.format("%.2f", totalInterest);
                    } else {
                        result = "Account does not exist";
                    }
                    break;
            }
            if (!result.isEmpty()) {
                System.out.println(result);
            }

            line = scanner.nextLine().split(" ");
            command = line[0];
        }
    }
}
