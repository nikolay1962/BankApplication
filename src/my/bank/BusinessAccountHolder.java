package my.bank;

public class BusinessAccountHolder extends AccountHolder {

    public BusinessAccountHolder(String name, Currency currency) {
        this.name = name;
        this.account = new Account(currency);
        this.type = "Business";
    }

    @Override
    public void addMoney(double money) {
        this.account.addMoney(money);
    }

    @Override
    public void withdrawMoney(double money) {
        this.account.withdrawMoney(money * 1.03);
    }
}
