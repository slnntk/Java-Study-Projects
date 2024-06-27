package domain.entities;

import domain.Coin;

public class Real implements Coin {
    @Override
    public String getSymbol() {
        return "BRL";
    }
}
