package my.bank;

public class Account {
    private double balance;
    private long number;
    private String currency;

    public Account(String currency) {
        this.balance = 0;
        this.number = (long)(Math.random() * 100000000000L);
        this.currency = currency;
    }

    public void AddMoney(double amountOfMoney) {
        this.balance += amountOfMoney;
    }

    public void withdrawMoney(double amountOfMoney) {
        this.balance -= amountOfMoney;
    }

    public double getBalance() {
        return balance;
    }

    public long getNumber() {
        return number;
    }

    public String getCurrency() {
        return currency;
    }


    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", number=" + number +
                ", currency='" + currency + '\'' +
                '}';
    }
}
