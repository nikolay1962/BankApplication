package my.bank;

public enum Currency {
    EUR("EUR"),
    GBP("GBP"),
    USD("USD"),
    RUR("RUR");

    String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return currency;
    }

    public static void main(String[] args) {
        System.out.println(EUR);
        System.out.println(USD);
        System.out.println(Currency.valueOf("GBP"));
        System.out.println(Currency.valueOf("EEK"));
    }
}
