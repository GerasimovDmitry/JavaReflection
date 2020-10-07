import testPackage.Human;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Class human = Human.class;
        try {
            Class anonObject = Class.forName("testPackage.Human.class");
            String fullClassName = anonObject.getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor[] constructors = human.getConstructors();

        try {
            Constructor constructor = human.getConstructor(new Class[]{String.class});
            Class[] parameterTypes = constructor.getParameterTypes();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Constructor constructor = null;
        try {
            constructor = Human.class.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Human newObject = (Human) constructor.newInstance("some string");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Field[] publicFields = human.getFields();
        Field[] moreFields = human.getDeclaredFields();

        Human newHuman = new Human();
        String name = null;
        Field field = null;
        try {
            field = newHuman.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(newHuman);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        field.getName();
        field.getType();
        try {
            field.set(newHuman, (String) "new value");
            field.get(newHuman);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        Class ClassObject = Human.class;
        Method[] methods = ClassObject.getMethods();

        Method method = null;
        try {
            method = ClassObject.getMethod("hello", new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Class[] parameterTypes = method.getParameterTypes();
        Class returnType = method.getReturnType();
    }
}
