import factory.CoinFactory;
import domain.Coin;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        createAndPrintCoin("Real");
        createAndPrintCoin("Dollar");
        createAndPrintCoin("x");
    }

    private static void createAndPrintCoin(String coinName) {
        try {
            Coin coin = CoinFactory.build(coinName)
                    .orElseThrow(() -> new IllegalArgumentException("Coin not found: " + coinName));
            System.out.println(coin.getSymbol());
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
        }
    }
}
