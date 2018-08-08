package my.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestAccountHolders {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccountHolders bank = new BankAccountHolders("My Bank of Account Holders");

        boolean proceed = true;
        while (proceed) {
            printOptions(bank.getBankName());
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    proceed = false;
                    break;
                case "2":
                    System.out.println(bank);
                    break;
                case "3":
                    addUser(bank);
                    break;
                case "4":
                    addMoneyToUser(bank);
                    break;
                case "5":
                    printUserData(bank);
                    break;
                case "6":
                    addAccountToUser(bank);
                    break;
                case "7":
                    withdrawMoney(bank);
                    break;
            }
        }
    }

    private static void printOptions(String bankName) {
        System.out.println(bankName + ": Possible actions");
        System.out.println("1 - to Quit");
        System.out.println("2 - List of users");
        System.out.println("3 - Add User");
        System.out.println("4 - Add money to user");
        System.out.println("5 - Print user data");
        System.out.println("6 - Add account to user");
        System.out.println("7 - withdraw money from user");
        System.out.print("Enter your choice:");

    }

    private static void withdrawMoney(BankAccountHolders bank) {
        System.out.print("Please, enter AccountHolder name:");
        String name = scanner.nextLine();
        System.out.print("Please, enter amount of Money to Withdraw:");
        double amountOfMoney = scanner.nextDouble();
        scanner.nextLine();
        bank.withdrawMoneyFromUser(name, amountOfMoney);
    }

    private static void addAccountToUser(BankAccountHolders bank) {
        System.out.print("Please, enter accountHolder:");
        String accountHolder = scanner.nextLine();
        System.out.print("Please, enter currency for Account:");
        String currency = scanner.nextLine();
        bank.addAccountToUser(accountHolder, currency);
    }

    private static void printUserData(BankAccountHolders bank) {
        System.out.print("Please, enter accountHolder:");
        String accountHolder = scanner.nextLine();
        bank.printUserData(accountHolder);
    }

    private static void addMoneyToUser(BankAccountHolders bank) {
        System.out.print("Please, enter accountHolder:");
        String accountHolder = scanner.nextLine();

        System.out.print("Please, enter amount of Money to add:");
        double amountOfMoney = scanner.nextDouble();
        scanner.nextLine();
        bank.addMoneyToUser(accountHolder, amountOfMoney);
    }

    private static void addUser(BankAccountHolders bank) {

        System.out.print("Please, enter accountHolder:");
        String accountHolder = scanner.nextLine();
        UserType userType = getUserType();
        Currency currency = getCurrency();

        switch (userType) {
            case PERSON:
                bank.addUser(accountHolder, currency);
                break;
            case BUSINESS:
                bank.addBusiness(accountHolder, currency);
                break;
            case FUND:
                bank.addFund(accountHolder, currency);
                break;
        }
    }

    private static UserType getUserType() {
        UserType userType = null;
        List<UserType> values = Arrays.asList(UserType.values());

        while (userType == null) {
            System.out.println("Please, select one or the following values:");
            for (int i = 0; i < values.size(); i++) {
                System.out.println("" + (i + 1) + " - " + values.get(i));
            }
            String reply = scanner.nextLine();
            try {
                int choice = Integer.parseInt(reply) - 1;
                if (choice >= 0 && choice < values.size()) {
                    userType = values.get(choice);
                }
            } catch (Exception e) {

            }
        }
        System.out.println("Your choice is " + userType);
        return userType;
    }

    private static Currency getCurrency() {
        Currency currency = null;
        List<Currency> values = Arrays.asList(Currency.values());

        while (currency == null) {
            System.out.println("Please, select one or the following values:");
            for (int i = 0; i < values.size(); i++) {
                System.out.println("" + (i + 1) + " - " + values.get(i));
            }
            String reply = scanner.nextLine();
            try {
                int choice = Integer.parseInt(reply) - 1;
                if (choice >= 0 && choice < values.size()) {
                    currency = values.get(choice);
                }
            } catch (Exception e) {
            }
        }
        System.out.println("Your choice is " + currency);
        return currency;
    }
}
