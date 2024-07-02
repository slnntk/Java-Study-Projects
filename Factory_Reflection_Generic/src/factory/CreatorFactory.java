package factory;

public class CreatorFactory {
    public static Creator returnCreator(String className) {
        Creator creator;
        try {
            Class<?> clazz = Class.forName("factory.Creator" + className);
            creator = (Creator) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return creator;
    }
}
