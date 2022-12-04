package ru.aleksandraKulikova.homeWorks.dz29.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // хотим чтобы аннотация была только для свойств класса
// если хотим несколько - берем в {}
@Retention(RetentionPolicy.RUNTIME) // аннотация времени выполения
public @interface Required {
}
