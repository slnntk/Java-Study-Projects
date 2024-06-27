package domain.entities;

import domain.Coin;

public class Dollar implements Coin {
    @Override
    public String getSymbol() {
        return "USD";
    }
}
