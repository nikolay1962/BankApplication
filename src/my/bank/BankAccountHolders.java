package my.bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccountHolders {
    private List<AccountHolder> accountHolders;
    private String bankName;

    public BankAccountHolders(String bankName) {
        this.bankName = bankName;
        this.accountHolders = new ArrayList<>();
    }

    public void addUser(String name, Currency currency) {
        AccountHolder newUser = new UserAccountHolder(name, currency);
        accountHolders.add(newUser);
    }

    public void addFund(String name, Currency currency) {
        AccountHolder newHolder = new FundAccountHolder(name, currency);
        accountHolders.add(newHolder);
    }

    public void addBusiness(String name, Currency currency) {
        AccountHolder accountHolder = new BusinessAccountHolder(name, currency);
        accountHolders.add(accountHolder);
    }

    public void addUser(AccountHolder newUser) {
        accountHolders.add(newUser);
    }

    public Double totalAmountOfUser(String name) {
        for (AccountHolder accountHolder : accountHolders) {
            if (accountHolder.name.equals(name)) {
                return accountHolder.totalAmountOfMoney();
            }
        }
        return null;
    }

    public void addMoneyToUser(String name, double amountOfMoney) {
        for (AccountHolder user : accountHolders) {
            if (user.name.equals(name)) {
                user.addMoney(amountOfMoney);
                return;
            }
        }
    }

    public void withdrawMoneyFromUser(String name, double amountOfMoney) {
        for (AccountHolder user :
                accountHolders) {
            if (user.name.equals(name)) {
                user.withdrawMoney(amountOfMoney);
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
        sb.append("accountHolders:");
        for (AccountHolder user : accountHolders) {
            sb.append(user).append(", ").append("\n");
        }
        sb.append('}');
        return sb.toString();
    }

    public void printUserData(String name) {
        for (AccountHolder user : accountHolders) {
            if (user.name.equals(name)) {
                System.out.println(user);
                break;
            }
        }
    }

    public void addAccountToUser(String name, String currency) {
        for (AccountHolder user : accountHolders) {
            if (user.name.equals(name)) {
                if (user.account == null) {
                    user.account = new Account(Currency.valueOf(currency));
                    break;
                }
            }
        }
    }
}
