import factory.CoinFactory;
import domain.Coin;

public class Main {
    public static void main(String[] args) {
        try {
            Coin real = CoinFactory.build("Real")
                    .orElseThrow(() -> new IllegalArgumentException("Coin not found"));
            System.out.println(real.getSymbol()); // BRL

            Coin dollar = CoinFactory.build("Dollar")
                    .orElseThrow(() -> new IllegalArgumentException("Coin not found"));
            System.out.println(dollar.getSymbol()); // USD

            Coin unknown = CoinFactory.build("x")
                    .orElseThrow(() -> new IllegalArgumentException("Coin not found"));
            System.out.println(unknown.getSymbol());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
