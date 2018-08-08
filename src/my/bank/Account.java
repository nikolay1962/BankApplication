package my.bank;

public class Account {
    private double balance;
    private long number;
    private Currency currency;

    public Account(Currency currency) {
        this.balance = 0;
        this.number = (long)(Math.random() * 100000000000L);
        this.currency = currency;
    }

    public void addMoney(double amountOfMoney) {
        this.balance += amountOfMoney;
    }

    public void withdrawMoney(double amountOfMoney) {
        if (this.balance >= amountOfMoney) {
            this.balance -= amountOfMoney;
        }
    }

    public double getBalance() {
        return balance;
    }

    public long getNumber() {
        return number;
    }

    public Currency getCurrency() {
        return currency;
    }


    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                " currency='" + currency + '\'' +
                "}\n";
    }
}
