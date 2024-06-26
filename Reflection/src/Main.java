import util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> myClass = Class.forName("domain.entities.Student");
        Object myObject = myClass.getConstructor().newInstance();

        Field field;
        field = myObject.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(myObject, "Cassio Tiago");

        field = myObject.getClass().getDeclaredField("code");
        field.setAccessible(true);
        field.set(myObject, 9);

        Class[] parameters = new Class[1];
        parameters[0] = double.class;

        /**
         * Para pegar um método especifico,
         * precisa passar o nome e os parametros
         * do método, ja que o método pode ser
         * sobrecarregado, então precisa ser especificado.
         */
        Method method;
        method = myObject.getClass().getDeclaredMethod("addGrade", parameters);
        // invoke é o métode que dispara o método.
        // invoke dispara a execução da instancia daquele método.
        method.invoke(myObject, 10.0);

        method = myObject.getClass().getDeclaredMethod("printData");
        method.invoke(myObject);
    }
}
