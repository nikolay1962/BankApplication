package my.bank;

import java.util.List;

public class Bank {
    List<User> users;
    String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addUser(String password,
                        String fullName,
                        String address,
                        String phoneNumber,
                        String email,
                        String secretQuestion,
                        String answerForSecretQuestion) {
        User newUser = new User(password, fullName,
                address, phoneNumber,
                email, secretQuestion,
                answerForSecretQuestion);
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
                user.addMoney(accountId, amountOfMoney);
            }
        }
    }

    public void withdrawMoneyFromUser(String userId, long accountId, double amountOfMoney) {
        for (User user :
                users) {
            if (user.getId().equals(userId)) {
                user.withdrawMoney(accountId, amountOfMoney);
            }
        }
    }
}
