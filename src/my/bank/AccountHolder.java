package my.bank;

public abstract class AccountHolder {

    protected String name;
    protected Account account;
    protected String type;

    public abstract void addMoney(double money);

    public abstract void withdrawMoney(double money);

    public Double totalAmountOfMoney(){
        return account.getBalance();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountHolder{");
        sb.append("name='").append(name).append('\'');
        sb.append("Type='").append(type).append('\'');
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }
}
