package ru.aleksandraKulikova.homeWorks.dz29.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    // параметры аннатоии: строки, примитивы и перечисления
    String configFile(); // обязательный параметр (должен быть указзан при использовании аннотации)

    long version() default 1; // параметр со значением по умолчанию, можно не указывать при использовании аннотации
}
