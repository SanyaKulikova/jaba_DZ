package ru.aleksandraKulikova.homeWorks.dz17.student;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTask {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>

        Map<Student.Gender, ArrayList<Student>> studentsMap = students.stream()
                // сделали мапу {ключ- гендер, значение - наш список студентов}
                .collect(Collectors.groupingBy( // группируем с помощью groupingBy
                        student -> student.getGender(),// Student::getGender - критерий группировки
                        Collectors.toCollection(ArrayList::new) // если мы хотим создать какой то конкретный лист
                        // в нашем случае ArrayList, то используем toCollection этот метод
                        ));
        System.out.println(studentsMap);



        //  2. Найти средний возраст учеников

        double avgAge = students.stream() // создаем переменную, в которой будет хранится средний возраст
                .mapToInt( student -> LocalDate.now().getYear() - student.getBirth().getYear()) // mapToInt - метод,
                // который принимает на вход функцию (у нас возраст учеников)
                .average().orElse(0); // у числовых потоков есть свои методы: например average()
        // average() возвращает Optional Container
        // Optional это тип данных,  который хранит ссылку на объект или ссылку на null
        // у этого типа данных ест методы orElse, get и isPresent
        // orElse  возвращает ссылку на объект, а если он null, дефолтное значение, которое мы сами задаем
        // get возвращает ссылку на объект или ошибку, если объект null
        // isPresent возвращает boolean
        System.out.println(avgAge); // IntStream

        // или

        System.out.println(
                students.stream().collect(Collectors.averagingInt( // averagingInt принимает на вход функцию
                        pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()))
        );


        //  3. Найти самого младшего ученика

        Student minAge1 = students.stream()
                .max((s1, s2) -> (int) (s1.getBirth().compareTo(s2.getBirth())))// тут max, а то наоборот будет
                                .get(); // max тоже возвращает Optional Container
        System.out.println(minAge1);

        // или
        // используем метод comparing класса Comparator - который сам делает компараторыи
        Student minAge2 = students.stream().max(Comparator.comparing(Student::getBirth)).orElse(null);
        System.out.println(minAge2);
        
        //  4. Найти самого старшего ученика

        Student maxAge = students.stream()
                .min((s1, s2) -> (int) (s1.getBirth().compareTo(s2.getBirth())))
                .get();
        System.out.println(maxAge);

        // или

        Student maxAge1 = students.stream().min(Comparator.comparing(Student::getBirth)).orElse(null);
        System.out.println(maxAge1);



        //  5. Собрать учеников в группы по году рождения

        Map<Integer, List<Student>> studentsMapByYear = students.stream() // просто List а не Array
                // тогла не нужно писать toCollection
                .collect(Collectors.groupingBy(
                        student -> student.getBirth().getYear()));
        System.out.println(studentsMapByYear);



        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        Collection<Student> uniqueByName = students.stream() // создаем коллекцию (на основе студентов)
                // и делаем поток на основе списка студентов
                .collect(Collectors.toMap( // используем метод toMap (который принимает на вход:
                        Student::getName, // student -> student.getName() // 1) функцию по кототорой делают ключи
                        Function.identity(),  // 2) функцию по которой возвращаются значения
                        // identity() возвращает тот же объект что и получил: student -> student
                        ((pupil, pupil2) -> pupil) // 3) функция, которая говорит что делать если ключи одинаковые
                )).values(); // возвращает коллекцию
        uniqueByName.forEach(pupil -> System.out.println(pupil.getName() + ": " + pupil.getBirth()));
        // выводим коллекцию с помощью метода forEach



        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        // не обязательно было использовать StreamIPI (так как тут только сортировка, а не сортирвка фильтрованных значений и тд)

        students.sort(
                // (st1, st2) -> st1.getXXX() сравнение с st2.getXXX()
                Comparator.comparing(Student::getGender) // st -> st.getGender()
                         // comparing принимает на вход компортаоры (создает их)
                        .thenComparing(Student::getBirth) // st -> st.getBirth()
                        .thenComparing(Student::getName).reversed() // st -> st.getName()
        );
        System.out.println(students);


        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        // опять не Stream

        int from = 10;
        int to = 10;
        students.forEach( // forEach  принимает на вход Consumer (а она может быть и со сраненим)
                pupil -> {
                    if (LocalDate.now().getYear() - pupil.getBirth().getYear() < to
                            && LocalDate.now().getYear() - pupil.getBirth().getYear() >= from) {
                        System.out.println(pupil);
                    }
                }
        );

        //  9. Собрать в список всех учеников с именем=someName

        List<Student> pupilsByName = students.stream()
                .filter(pupil -> pupil.getName().equals("Петр"))
                .toList();


        //  10. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола

        Map<Student.Gender, Integer> genderCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.summingInt( // summingInt - метод возвращает сумму
                                pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())));
        System.out.println(genderCount);

    }
}
