package my.bank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank("My personal Bank");

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

    private static void withdrawMoney(Bank bank) {
        System.out.print("Please, enter UserId:");
        String userId = scanner.nextLine();
        System.out.print("Please, enter accountId:");
        long accountId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Please, enter amount of Money to Withdraw:");
        double amountOfMoney = scanner.nextDouble();
        scanner.nextLine();
        bank.withdrawMoneyFromUser(userId, accountId, amountOfMoney);
    }

    private static void addAccountToUser(Bank bank) {
        System.out.print("Please, enter UserId:");
        String userId = scanner.nextLine();
        System.out.print("Please, enter currency for Account:");
        String currency = scanner.nextLine();
        bank.addAccountToUser(userId, currency);
    }

    private static void printUserData(Bank bank) {
        System.out.print("Please, enter UserId:");
        String userId = scanner.nextLine();
        bank.printUserData(userId);
    }

    private static void addMoneyToUser(Bank bank) {
        System.out.print("Please, enter UserId:");
        String userId = scanner.nextLine();
        System.out.print("Please, enter accountId:");
        long accountId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Please, enter amount of Money to add:");
        double amountOfMoney = scanner.nextDouble();
        scanner.nextLine();
        bank.addMoneyToUser(userId, accountId, amountOfMoney);
    }

    private static void addUser(Bank bank) {
        System.out.print("Please, enter password:");
        String password = scanner.nextLine();
        System.out.print("Please, enter fullName:");
        String fullName = scanner.nextLine();
        System.out.print("Please, enter address:");
        String address = scanner.nextLine();
        System.out.print("Please, enter phoneNumber:");
        String phoneNumber = scanner.nextLine();
        System.out.print("Please, enter email:");
        String email = scanner.nextLine();
        System.out.print("Please, enter secretQuestion:");
        String secretQuestion = scanner.nextLine();
        System.out.print("Please, enter answerForSecretQuestion:");
        String answerForSecretQuestion = scanner.nextLine();
        UserType userType = getUserType();
        bank.addUser(password, fullName, address, phoneNumber, email, secretQuestion, answerForSecretQuestion, userType);
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
}
