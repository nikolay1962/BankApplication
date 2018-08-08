package my.bank;

public class UserAccountHolder extends AccountHolder{

    public UserAccountHolder(String name, Currency currency) {
        this.name = name;
        this.account = new Account(currency);
        this.type = "User";
    }

    @Override
    public void addMoney(double money) {
        this.account.addMoney(money);
    }

    @Override
    public void withdrawMoney(double money) {
        this.account.withdrawMoney(money * 1.05);
    }
}
