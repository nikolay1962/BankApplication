package my.bank;

public class FundAccountHolder extends AccountHolder{

    public FundAccountHolder(String name, Currency currency) {
        this.name = name;
        this.account = new Account(currency);
        this.type = "Fund";
    }

    @Override
    public void addMoney(double money) {
        this.account.addMoney(money);
    }

    @Override
    public void withdrawMoney(double money) {
        this.account.withdrawMoney(money);
    }
}
