package my.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String password;
    private String fullName;
    private String address;
    private List<Account> accounts;
    private String phoneNumber;
    private String email;
    private String secretQuestion;
    private String answerForSecretQuestion;
    private UserType userType;

    public User(String password,
                String fullName,
                String address,
                String phoneNumber,
                String email,
                String secretQuestion,
                String answerForSecretQuestion,
                UserType userType) {
        this.id = UUID.randomUUID().toString();
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.answerForSecretQuestion = answerForSecretQuestion;
        this.userType = userType;
        this.accounts = new ArrayList<>();
    }

    public double totalAmountOfMoney() {
        double totalAmount = 0;
        for (Account account : accounts) {
            totalAmount += account.getBalance();
        }
        return totalAmount;
    }

    public void addMoneyToAccount(long accountId, double amountOfMoney) {
        for (Account account : accounts) {
            if (account.getNumber() == accountId) {
                account.addMoney(amountOfMoney);
                return;
            }
        }
    }

    public void withdrawMoney(long accountId, double amountOfMoney) {
        for (Account account : accounts) {
            if (account.getNumber() == accountId) {
                account.withdrawMoney(amountOfMoney);
                return;
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addNewAccount(String currency) {
        Account newAccount = new Account(Currency.valueOf(currency));
        accounts.add(newAccount);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getAnswerForSecretQuestion() {
        return answerForSecretQuestion;
    }

    public void setAnswerForSecretQuestion(String answerForSecretQuestion) {
        this.answerForSecretQuestion = answerForSecretQuestion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", secretQuestion='").append(secretQuestion).append('\'');
        sb.append(", answerForSecretQuestion='").append(answerForSecretQuestion);
        sb.append(", User type='").append(userType).append("'\n");
        sb.append(", accounts=").append(accounts);
        sb.append('}');
        return sb.toString();
    }
}
