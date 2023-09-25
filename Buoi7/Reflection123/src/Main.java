import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> classStudent = Class.forName("Student");

            //Bai 1
//            Constructor<?>[] constructors = classStudent.getConstructors();
//            for (Constructor<?>  disContructor: constructors
//                 ) {
//                System.out.println(disContructor);
//            }

            //Bai 2
            Method[] methods = classStudent.getMethods();
            int modifier = classStudent.getModifiers();
            for (Method disMethod : methods
            ) {
                if (Modifier.isStatic(disMethod.getModifiers())) {
                    System.out.println(disMethod);
                }
            }

//            Method[] methods1 = classStudent.getDeclaredMethods();
//            for (Method methodDis: methods1
//                 ) {
//                System.out.println(methodDis);
//            }


            //Bai3
            Method method = classStudent.getMethod("result");
            method.invoke(new Student());



        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}