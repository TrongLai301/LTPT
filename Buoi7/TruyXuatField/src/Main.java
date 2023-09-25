import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Myclass1");

            Field[] fields = clazz.getFields();

            for (Field field: fields
                 ) {
                String fieldName = field.getName();
                System.out.println("Field Name: "+ fieldName);

                Class<?> fieldType = field.getType();
                System.out.println("Field Type: " + fieldType.getName());

                int modfiers = field.getModifiers();
                System.out.println("Modifiers: "+ Modifier.toString(modfiers));

                Myclass1 instance = new Myclass1();

                Object fieldValue = field.get(instance);
                System.out.println("Field Value: "+fieldValue);

                System.out.println();
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}