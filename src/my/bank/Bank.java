package my.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.users = new ArrayList<>();
    }

    public void addUser(String password, String fullName,
                        String address,  String phoneNumber,
                        String email,    String secretQuestion,
                        String answerForSecretQuestion,
                        UserType userType) {
        User newUser = new User(password, fullName,
                address, phoneNumber,
                email, secretQuestion,
                answerForSecretQuestion,
                userType);
        users.add(newUser);
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public Double totalAmountOfUser(String userID) {
        for (User user : users) {
            if (user.getId().equals(userID)) {
                return user.totalAmountOfMoney();
            }
        }
        return null;
    }

    public void addMoneyToUser(String userId, long accountId, double amountOfMoney) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                user.addMoneyToAccount(accountId, amountOfMoney);
                return;
            }
        }
    }

    public void withdrawMoneyFromUser(String userId, long accountId, double amountOfMoney) {
        for (User user :
                users) {
            if (user.getId().equals(userId)) {
                user.withdrawMoney(accountId, amountOfMoney);
                return;
            }
        }
    }

    public String getBankName() {
        return bankName;
    }

    public void printUsers() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append("users:");
        for (User user : users) {
            sb.append(user.getId()).append(", ").append(user.getFullName()).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }

    public void printUserData(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                System.out.println(user);
                break;
            }
        }
    }

    public void addAccountToUser(String userId, String currency) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                user.addNewAccount(currency);
                break;
            }
        }
    }
}
