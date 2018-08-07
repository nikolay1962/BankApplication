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

    public User(String password,
                String fullName,
                String address,
                String phoneNumber,
                String email,
                String secretQuestion,
                String answerForSecretQuestion) {
        this.id = UUID.randomUUID().toString();
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.secretQuestion = secretQuestion;
        this.answerForSecretQuestion = answerForSecretQuestion;
        this.accounts = new ArrayList<>();
    }

    public double totalAmountOfMoney() {
        double totalAmount = 0;
        for (Account account :
                accounts) {
            totalAmount += account.getBalance();
        }
        return totalAmount;
    }

    public void addMoney(long accountId, double amountOfMoney) {
        for (Account account :
                accounts) {
            if (account.getNumber() == accountId) {
                account.AddMoney(amountOfMoney);
            }
        }
    }

    public void withdrawMoney(long accountId, double amountOfMoney) {
        for (Account account :
                accounts) {
            if (account.getNumber() == accountId) {
                account.withdrawMoney(amountOfMoney);
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
        Account newAccount = new Account(currency);
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
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", answerForSecretQuestion='" + answerForSecretQuestion + '\'' +
                '}';
    }
}
