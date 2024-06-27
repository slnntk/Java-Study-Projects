package factory;

import domain.Coin;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoinFactory {
    private static final Logger logger = Logger.getLogger(CoinFactory.class.getName());

    public static Optional<Coin> build(String coinName) {
        if (coinName == null || coinName.trim().isEmpty()) {
            logger.log(Level.SEVERE, "Coin name cannot be null or empty");
            return Optional.empty();
        }

        try {
            String className = getClassName(coinName);
            Class<?> coinClass = getClassForName(className);
            return createInstance(coinClass);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Coin class not found: " + coinName, e);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            logger.log(Level.SEVERE, "Error creating coin instance: " + coinName, e);
        }
        return Optional.empty();
    }

    private static String getClassName(String coinName) {
        return "domain.entities." + coinName;
    }

    private static Class<?> getClassForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    private static Optional<Coin> createInstance(Class<?> coinClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return Optional.of((Coin) coinClass.getDeclaredConstructor().newInstance());
    }
}
