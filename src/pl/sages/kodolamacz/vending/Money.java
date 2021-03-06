package pl.sages.kodolamacz.vending;

public class Money {

    // wartość w groszach
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public static Money zero(){
        return new Money(0);
    }

    // przeciążamy metodę add
    public Money add(Coin coin) {
        return new Money(this.value + coin.getValue());
    }
    public Money add(Money other){
        return new Money(this.value + other.value);
    }

    public Money minus(Money other) {
        return new Money(this.value - other.value);
    }

    public Money minus(Coin coin) {
        return new Money(this.value - coin.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return value == money.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        // warunek ? jesli TRUE : jesli FALSE
        String grosze = String.valueOf(value);
        return value/100 + "." + grosze.substring(grosze.length()-2) + " PLN";
//        return value/100 + "." + value % 100 + " PLN";
        // 2.50 PLN
    }

    public boolean greaterThanOrEqualTo(Money other) {
        return this.value >= other.value;
    }

    public boolean greaterThanOrEqualTo(Coin other) {
        return this.value >= other.getValue();
    }
}