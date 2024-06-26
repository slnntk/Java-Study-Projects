package util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class ReflectionUtils {

    private ReflectionUtils() {
    }

    private static final Logger logger = Logger.getLogger(ReflectionUtils.class.getName());

    public static void reflectObject(Object obj, Class<?> clazz) throws IllegalAccessException, IllegalArgumentException {
        logger.info("========================================================");
        logger.info(() -> "Class Name: " + clazz.getName() + "\n");
        logger.info(() -> "Simple Class Name: " + clazz.getSimpleName() + "\n");
        logger.info(() -> "Canonical Class Name: " + clazz.getCanonicalName() + "\n");

        logger.info(() -> "Type: " + clazz.getTypeName() + "\n");
        logger.info(() -> "Superclass: " + clazz.getSuperclass().getName() + "\n");

        logger.info("========================================================");

        logger.info("Class Attributes: " + "\n");

        Field[] attributes = clazz.getDeclaredFields();
        for (Field field : attributes) {
            field.setAccessible(true);
            // Any primitive type in java can receive 0.
            // All object types can be set as null.
            logger.info(() -> {
                try {
                    return String.format(
                            "Attribute: %s %n Type: %s %n Value: %s %n Primitive: %b %n Array: %b %n Interface: %b %n Access Modifier: %d%n",
                            field.getName(),
                            field.getType().getName(),
                            field.get(obj),
                            field.getType().isPrimitive(),
                            field.getType().isArray(),
                            field.getType().isInterface(),
                            field.getModifiers()
                    );
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        logger.info("========================================================");
        logger.info("Class methods: " + "\n");

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            logger.info(() -> String.format(
                    "Method: %s %n Parameters: %s %n Return Type: %s %n Modifier: %d %n",
                    method.getName(),
                    Arrays.toString(method.getParameterTypes()),
                    method.getReturnType().getName(),
                    method.getModifiers()
            ));
        }
    }
}