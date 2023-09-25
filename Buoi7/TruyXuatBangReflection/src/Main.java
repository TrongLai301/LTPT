import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> newClass = null;
        try {
            newClass = Class.forName("JavaReflaction");
            System.out.println(newClass.getName());

            int modifiers = newClass.getModifiers();
            System.out.println(modifiers);

            Field[] fields = newClass.getFields();
            System.out.println("Public Fields:");
            for (Field field : fields) {
                System.out.println(field);
            }

            Method[] methods = newClass.getMethods();
            System.out.println("Public Method:");
            for (Method method : methods
            ) {
                System.out.println(method);
            }

            Constructor<?>[] constructors = newClass.getConstructors();
            System.out.println("Public Contructors:");
            for (Constructor<?> constructor: constructors
                 ) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}