package ru.aleksandraKulikova.homeWorks.dz29;

// Задача 1
//Реализовать рекурсивный метод public static void reflectionToString(Object object) { },
// используя рефлексию. Метод toString класса Object не использовать

import java.lang.reflect.Field;

public class ReflectionHW {

    public static void reflectionToString(Object object) throws IllegalAccessException {
        Class<? extends Object> classOfObject = object.getClass();
        Field[] fields = classOfObject.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isPrimitive()) {
                field.setAccessible(true);
                System.out.println( " Поле " + field.getName() + " = " + field.get(classOfObject));
            } else reflectionToString(field);
        }

    }
}
