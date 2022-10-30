package ru.aleksandraKulikova.homeWorks.dz14.message;

public enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT;

    public static MessagePriority getPriority(int ord){
        for (MessagePriority mp: values()){ // то есть идет пербор массива MessagePriority
            if (ord == mp.ordinal()) { // если то , что передали равно индексу приоритета в массиве
                return mp;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}
