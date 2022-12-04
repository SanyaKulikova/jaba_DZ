package ru.aleksandraKulikova.homeWorks.dz29.annotations;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class AnnotationHW {

    public static Object getInstance(Class<?> cls) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (cls.isAnnotationPresent(Config.class)){
            Constructor<?> clsConstructor = cls.getDeclaredConstructor();
            Object newObject = clsConstructor.newInstance();
            Field[] newObjectFields = cls.getDeclaredFields();
            Config config = cls.getDeclaredAnnotation(Config.class);
            Properties properties = new Properties();
            for (Field field : newObjectFields) {
                if (field.isAnnotationPresent(Required.class)){
                    try(InputStream input = AnnotationHW.class.getClassLoader().getResourceAsStream(config.configFile())) {
                        properties.load(input);
                    } catch (IOException e) {
                        System.out.println("Проблемы с чтением config.properties");
                    }
                    field.setAccessible(true);
                    field.set(newObject, properties.getProperty(field.getName()));
                }
            }
            return newObject;
        } else return null;

    }
}

