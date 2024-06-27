package factory;

import domain.Coin;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class CoinFactory {
    public static Optional<Coin> build(String coinName) {
        try {
            // Monta o nome completo da classe com o pacote
            String className = "domain.entities." + coinName;
            // Obtém a classe a partir do nome
            Class<?> coinClass = Class.forName(className);
            // Cria uma nova instância da classe
            return Optional.of((Coin) coinClass.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
